package com.example.tommorow.ui;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tommorow.BaseActivity;
import com.example.tommorow.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 闹钟的页面
 */

public class SettingAlarmActivity extends BaseActivity {
    @BindView(R.id.hour)
    EditText hour;
    @BindView(R.id.minute)
    EditText minute;
    @BindView(R.id.message)
    EditText message;
    @BindView(R.id.set)
    Button set;

    private String mHour, mMinute, mMessage;


    @Override
    public int getContnetView() {
        return R.layout.activity_setting_alarm;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setEditTextInhibitInputSpace(hour);
        setEditTextInhibitInputSpace(minute);
        setEditTextInhibitInputSpace(message);
        title.setText(getResources().getString(R.string.alarm));
    }

    @OnClick(R.id.set)
    public void onViewClicked() {
        mHour = hour.getText().toString();
        mMinute = minute.getText().toString();
        mMessage = message.getText().toString();
        if (TextUtils.isEmpty(mMinute) || TextUtils.isEmpty(mHour) || TextUtils.isEmpty(mMessage)) {
            Toast.makeText(SettingAlarmActivity.this, getString(R.string.input_complete_message), Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, mMessage);
        intent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(mHour));
        intent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(mMinute));
        startActivity(intent);
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
}
