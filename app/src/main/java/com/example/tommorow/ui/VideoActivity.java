package com.example.tommorow.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.tommorow.BaseActivity;
import com.example.tommorow.R;

import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/5/3.
 */

public class VideoActivity extends BaseActivity{

    VideoView myVideo;
    private MediaController media_control;
    @Override
    public int getContnetView() {
        return R.layout.activity_video;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        title.setText("Exercise Video");
        myVideo = (VideoView) findViewById(R.id.videoView);
        media_control = new MediaController(this);
        Intent intent = getIntent();
        String uriString = intent.getStringExtra("url");
        Uri uri = Uri.parse(uriString);
        myVideo.setMediaController(media_control);
        myVideo.setVideoURI(uri);
        myVideo.start();
    }
}
