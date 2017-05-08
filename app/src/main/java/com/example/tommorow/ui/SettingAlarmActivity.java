package com.example.tommorow.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.tommorow.BaseActivity;
import com.example.tommorow.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by lenovo on 2017/4/22.
 * Controller class, corresponding to layout file
 * This class will handle the alarm setting logic
 * Layout file name: activity_setting_alarm.xml
 */
public class SettingAlarmActivity extends BaseActivity {

    @BindView(R.id.medicine_name)
    EditText medicine_name;
    @BindView(R.id.medicine_amount)
    EditText medicine_amount;
    @BindView(R.id.set)
    Button set;

    private int hour;
    private int minutes;

    private String mName,mAmount,mMessage,mHint;


    @Override
    public int getContnetView() {
        return R.layout.activity_setting_alarm;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        //set up title
        title.setText(getResources().getString(R.string.alarm));
        setEditTextInhibitInputSpace(medicine_name);
        setEditTextInhibitInputSpace(medicine_amount);
        TimePicker simpleTimePicker = (TimePicker)findViewById(R.id.simpleTimePicker); // initiate a time picker
        // set up time picker listener
        simpleTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                hour = hourOfDay;
                minutes = minute;
            }
        });
    }

    @OnClick(R.id.set)
    public void onViewClicked() {
        mName = medicine_name.getText().toString();
        mAmount = medicine_amount.getText().toString();

        if (TextUtils.isEmpty(mName) || TextUtils.isEmpty(mAmount)) {
            alertWindow(getString(R.string.input_complete_message));
            return;
        }
        mMessage = "Reminder! Don't forget to take " + mAmount + " " +  mName;
        mHint = "Here are the information you enter:" + "\n" +
                "Name: " + mName + "\n" +
                "Amount: " + mAmount + "\n" +
                "Time: " + hour + ":" + minutes;
        AlertDialog.Builder builder1 = new AlertDialog.Builder(SettingAlarmActivity.this);
        builder1.setTitle("Confirmation!");
        builder1.setMessage(mHint);
        builder1 .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_MESSAGE, mMessage);
                intent.putExtra(AlarmClock.EXTRA_HOUR, hour);
                intent.putExtra(AlarmClock.EXTRA_MINUTES, minutes);
                startActivity(intent);
            }
        });
        builder1.setNegativeButton(
                "Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert11 = builder1.create();
        alert11.show();

    }

    public void alertWindow(String str){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(SettingAlarmActivity.this);
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
