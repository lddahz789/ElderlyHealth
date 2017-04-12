package com.example.tommorow.ui;

import android.os.Bundle;

import com.example.tommorow.BaseActivity;
import com.example.tommorow.R;

import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/4/10.
 */

public class SettingActivity extends BaseActivity {


    @Override
    public int getContnetView() {
        return R.layout.activity_setting;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        title.setText(getResources().getString(R.string.setting));
    }



}
