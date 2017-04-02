package com.example.tommorow.ui;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tommorow.BaseActivity;
import com.example.tommorow.Constant.Const;
import com.example.tommorow.R;
import com.example.tommorow.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 求助Activity
 */

public class HelpActivity extends BaseActivity {
    @BindView(R.id.send)
    Button send;
    @BindView(R.id.call)
    Button call;
    @BindView(R.id.content)
    EditText content;

    @Override
    public int getContnetView() {
        return R.layout.activity_help;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        title.setText(getResources().getString(R.string.help));
        if (!SharedPreferencesUtil.getInstance(this).getBoolean(Const.IS_CHILD)) {
            content.setVisibility(View.GONE);
            send.setVisibility(View.GONE);
        }
    }

    @OnClick({R.id.send, R.id.call})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.send:
                //发送短信
                send();
                break;
            case R.id.call:
                //拨打电话
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                //url:统一资源定位符
                //uri:统一资源标示符（更广）
                intent.setData(Uri.parse("tel:" + SharedPreferencesUtil.getInstance(this).getString(Const.PHONE_NUMBER)));
                //开启系统拨号器
                startActivity(intent);
                break;
        }
    }

    private void send() { //创建一个PendingIntent对象
        if (TextUtils.isEmpty(content.getText().toString())) {
            Toast.makeText(HelpActivity.this, getResources().getString(R.string.input_complete_message), Toast.LENGTH_LONG).show();
            return;
        }

        PendingIntent pi = PendingIntent.getActivity(
                HelpActivity.this, 0, new Intent(), 0);
        //获取SmsManager
        SmsManager sManager = SmsManager.getDefault();
        //发送短信
        sManager.sendTextMessage(SharedPreferencesUtil.getInstance(this).getString(Const.PHONE_NUMBER), null, content.getText().toString(), pi, null);

    }

}
