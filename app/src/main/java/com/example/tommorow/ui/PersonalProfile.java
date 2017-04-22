package com.example.tommorow.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.tommorow.BaseActivity;
import com.example.tommorow.Constant.Const;
import com.example.tommorow.R;
import com.example.tommorow.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/4/22.
 */

public class PersonalProfile extends BaseActivity {

    @BindView(R.id.profile_fullName)
    TextView fullName;
    @BindView(R.id.profile_gender)
    TextView gender;
    @BindView(R.id.profile_phoneNum)
    TextView phoneNum;
    @BindView(R.id.profile_relativePhone)
    TextView relativePhone;
    @BindView(R.id.profile_birth)
    TextView birth;
    @BindView(R.id.profile_weight)
    TextView weight;
    @BindView(R.id.profile_preference_btn)
    Button preference_btn;
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

    }

    private void init(){
        fullName.setText(SharedPreferencesUtil.getInstance(this).getString(Const.FULLNAME));
        gender.setText("Gender:   "+ SharedPreferencesUtil.getInstance(this).getString(Const.GENDER));
        weight.setText("Weight:   " + SharedPreferencesUtil.getInstance(this).getString(Const.WEIGHT) + "Kg");
        phoneNum.setText("Phone Number:   "+SharedPreferencesUtil.getInstance(this).getString(Const.USER_NAME));
        relativePhone.setText("Relative's Phone Number:   "+SharedPreferencesUtil.getInstance(this).getString(Const.PHONE_NUMBER));
        birth.setText("Birth Day:   "+SharedPreferencesUtil.getInstance(this).getString(Const.BIRTH));
    }
}
