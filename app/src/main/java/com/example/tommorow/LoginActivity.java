package com.example.tommorow;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.tommorow.Constant.Const;
import com.example.tommorow.db.UserDBUtils;
import com.example.tommorow.entity.User;
import com.example.tommorow.utils.SharedPreferencesUtil;
import com.example.tommorow.utils.StringUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/4/22.
 * Controller class, corresponding to layout file
 * This class will handle the log in logic
 * Layout file name: activity_login.xml
 */
public class LoginActivity extends Activity implements MediaPlayer.OnCompletionListener{
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.passWord)
    EditText passWord;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.register)
    Button register;
    private String mName, mPassWord;
    private List<User> userList;
    VideoView videoview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setEditTextInhibitInputSpace(name);
        setEditTextInhibitInputSpace(passWord);

        videoview = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.old);
        videoview.setVideoURI(uri);
        videoview.start();
        videoview.setOnCompletionListener(this);
    }



    @OnClick({R.id.login, R.id.register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login:
                mName = name.getText().toString().toString();
                mPassWord = passWord.getText().toString().trim();
                if (TextUtils.isEmpty(StringUtils.c(mName)) || TextUtils.isEmpty(StringUtils.c(mPassWord))) {
                    Toast.makeText(LoginActivity.this, "Incomplete Information!", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    boolean isLogin = false;
                    UserDBUtils userDBUtils = new UserDBUtils(this);
                    userList = userDBUtils.queryAllUser();
                    for (int i = 0; i < userList.size(); i++) {
                        if (userList.get(i).getChildName().equals(mName) && userList.get(i).getPassWord().equals(mPassWord)) {
                            isLogin = true;
                            if (userList.get(i).getChildName().equals(mName)) {
                                SharedPreferencesUtil.getInstance(this).putBoolean(Const.IS_CHILD, true);
                                SharedPreferencesUtil.getInstance(this).putString(Const.PHONE_NUMBER, userList.get(i).getName());
                            } else {
                                SharedPreferencesUtil.getInstance(this).putString(Const.PHONE_NUMBER, userList.get(i).getChildName());
                            }
                            SharedPreferencesUtil.getInstance(this).putString(Const.USER_NAME, mName);
                            //send weight and birthday & full name parameters to main activity
                            SharedPreferencesUtil.getInstance(this).putString(Const.BIRTH, userList.get(i).getBirthday());
                            SharedPreferencesUtil.getInstance(this).putString(Const.WEIGHT, userList.get(i).getWeight());
                            SharedPreferencesUtil.getInstance(this).putString(Const.FULLNAME, userList.get(i).getFullName());
                            SharedPreferencesUtil.getInstance(this).putString(Const.GENDER, userList.get(i).getGender());
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_LONG).show();
                            startActivity(intent);
                        }
                    }
                    if (!isLogin) {
                        Toast.makeText(LoginActivity.this, R.string.username_passwd_error, Toast.LENGTH_LONG).show();
                    }
                }
                break;
            case R.id.register:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void setEditTextInhibitInputSpace(EditText editText) {
        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (source.equals(" ")) {
                    return "";
                } else return null;
            }
        };
        editText.setFilters(new InputFilter[]{filter});
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        videoview.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoview.start();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        videoview.start();
    }
}
