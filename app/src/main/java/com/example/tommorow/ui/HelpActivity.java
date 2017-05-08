package com.example.tommorow.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tommorow.BaseActivity;
import com.example.tommorow.Constant.Const;
import com.example.tommorow.R;
import com.example.tommorow.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/4/22.
 * Controller class, corresponding to layout file
 * Handle the emergency activity logic
 * Layout file name: activity_help.xml
 */
public class HelpActivity extends BaseActivity {
    @BindView(R.id.send)
    Button send;
    @BindView(R.id.call)
    Button call;
    @BindView(R.id.callAndMessage)
    Button callAndMessage;
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
        content.setText("URGENT Please help me, I need emergency help!");
    }

    @OnClick({R.id.send, R.id.call,R.id.callAndMessage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.send:
                //Send message
                SendSMSTo(SharedPreferencesUtil.getInstance(this).getString(Const.PHONE_NUMBER),content.getText().toString() + "  My Cordinates: -37.8786037,145.045115");
                break;
            case R.id.call:
                //Make phone Calls
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + SharedPreferencesUtil.getInstance(this).getString(Const.PHONE_NUMBER)));
                startActivity(intent);
                break;
            case R.id.callAndMessage:

                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_CALL);
                intent2.setData(Uri.parse("tel:" + SharedPreferencesUtil.getInstance(this).getString(Const.PHONE_NUMBER)));
                startActivity(intent2);
                SendSMSTo(SharedPreferencesUtil.getInstance(this).getString(Const.PHONE_NUMBER),content.getText().toString() + "  My Cordinates: -37.8786037,145.045115");
                break;
        }
    }

    /**
     * @param phoneNumber
     * @param message
     * send message function
     */
    public void SendSMSTo(String phoneNumber,String message){
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+phoneNumber));
            intent.putExtra("sms_body", message);
            startActivity(intent);
    }
}
