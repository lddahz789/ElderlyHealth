package com.example.tommorow;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tommorow.R;


/**
 * Activity基类  封装toolbar
 */

public abstract class BaseActivity extends Activity {
    public  ImageView backImageView;
  public   TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContnetView());
        backImageView = (ImageView) findViewById(R.id.back);
        title = (TextView) findViewById(R.id.title);
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public abstract int getContnetView();


}
