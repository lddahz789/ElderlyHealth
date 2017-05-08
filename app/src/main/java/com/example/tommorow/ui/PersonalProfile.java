package com.example.tommorow.ui;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tommorow.BaseActivity;
import com.example.tommorow.Constant.Const;
import com.example.tommorow.R;
import com.example.tommorow.db.DBHelper;
import com.example.tommorow.utils.SharedPreferencesUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/4/22.
 * Controller class, corresponding to layout file
 * Handle map personal profile logic
 * Users can check, update their basic informations
 * Layout file name: activity_profile.xml
 */
public class PersonalProfile extends BaseActivity {
    private SQLiteDatabase db;
    private DBHelper myDBHelper;
    @BindView(R.id.profile_fullName)
    TextView fullName;
    @BindView(R.id.profile_gender)
    TextView gender;
    @BindView(R.id.profile_phoneNum)
    TextView phoneNum;
    @BindView(R.id.profile_relativePhone)
    EditText relativePhone;
    @BindView(R.id.profile_birth)
    TextView birth;
    @BindView(R.id.profile_weight)
    EditText weight;
    @BindView(R.id.profile_update_btn)
    Button profile_update_btn;
    @Override
    public int getContnetView() {
        return R.layout.activity_profile;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        title.setText(getResources().getString(R.string.profile));

        init();
        myDBHelper = new DBHelper(PersonalProfile.this);
    }

    public String dateFormat(String strDate){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        String output = null;
        try {
            date = dateFormat.parse(strDate);
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            output = df.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return output;
    }

    /**
     * initiate personal data from const
     */
    private void init(){

        fullName.setText(SharedPreferencesUtil.getInstance(this).getString(Const.FULLNAME));
        gender.setText("Gender: \n"+ SharedPreferencesUtil.getInstance(this).getString(Const.GENDER));
        phoneNum.setText("Phone Number: \n"+SharedPreferencesUtil.getInstance(this).getString(Const.USER_NAME));
        birth.setText("Birth Day: \n"+ dateFormat(SharedPreferencesUtil.getInstance(this).getString(Const.BIRTH)));

        relativePhone.setText(SharedPreferencesUtil.getInstance(this).getString(Const.PHONE_NUMBER));
        weight.setText(SharedPreferencesUtil.getInstance(this).getString(Const.WEIGHT));

        de.hdodenhof.circleimageview.CircleImageView imageHead = (de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.circle_image2);
        if(!isMale()){
            imageHead.setImageResource(R.drawable.female);
        }
    }


    @OnClick(R.id.profile_update_btn)
    public void onViewClicked() {
        db = myDBHelper.getReadableDatabase();
        String mRelativePhone = relativePhone.getText().toString().trim();
        String mWeight = weight.getText().toString().trim();
        String mainAcount = SharedPreferencesUtil.getInstance(this).getString(Const.USER_NAME);

        if (!isValidPhone(mRelativePhone)){
            alertWindow("Please use validate phone number in Austalia! \n E.g. 0432068888");
        }else{
            ContentValues values = new ContentValues();
            values.put("name", mRelativePhone);
            values.put("weight", mWeight);
            db.update("user", values, "childname = ?", new String[]{mainAcount});

            SharedPreferencesUtil.getInstance(this).putString(Const.PHONE_NUMBER, mRelativePhone);
            SharedPreferencesUtil.getInstance(this).putString(Const.WEIGHT, mWeight);
            Toast.makeText(PersonalProfile.this, "Information updated!", Toast.LENGTH_SHORT).show();
    }}


    /**
     * @return
     * check if the user is male
     * for differenct tittles and icons
     */
    public boolean isMale(){
        return SharedPreferencesUtil.getInstance(this).getString(Const.GENDER).equals("male");
    }

    /**
     * @param phone
     * @return
     * check whether if the phone nunber is valid
     */
    public boolean isValidPhone(String phone){
        String regex = "^[0][0-9]{9}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phone);
        return m.matches();
    }


    public void alertWindow(String str){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(PersonalProfile.this);
        builder1.setTitle("Warning");
        builder1.setMessage(str);
        builder1 .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }



}
