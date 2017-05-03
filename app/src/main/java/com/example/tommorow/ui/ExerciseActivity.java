package com.example.tommorow.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.tommorow.BaseActivity;
import com.example.tommorow.R;
import com.example.tommorow.adapter.VideoAdapter;
import com.example.tommorow.entity.Video;

import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/5/3.
 */

public class ExerciseActivity extends BaseActivity implements AdapterView.OnItemClickListener {


    private List<Video> mData = null;
    private Context mContext;
    private VideoAdapter mAdapter = null;
    private ListView list_video;
    private LinearLayout ly_content;

    @Override
    public int getContnetView() {
        return R.layout.activity_exercise;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        title.setText(getResources().getString(R.string.exericise));
        mContext = ExerciseActivity.this;
        list_video = (ListView) findViewById(R.id.listViewVideo);
        mData = new LinkedList<Video>();
        mData.add(new Video("Senior Fitness lesson 1", "This video teaches senior people using sticks to stretch muscle and relax body.", R.drawable.p1));
        mData.add(new Video("Senior Fitness lesson 2", "This video teaches senior people using balls to massage muscle and relax body.", R.drawable.p2));
        mData.add(new Video("Senior Fitness lesson 3", "This video teaches senior people using rings to make body flexible.", R.drawable.p3));
        mAdapter = new VideoAdapter((LinkedList<Video>) mData, mContext);
        list_video.setAdapter(mAdapter);
        list_video.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        String name = "v" + ( i + 1 );
        int rawId = getResources().getIdentifier(name,"raw",getPackageName());
        String path = "android.resource://" + getPackageName() + "/" + rawId;
//       Toast.makeText(mContext,path,Toast.LENGTH_SHORT).show();

        Intent exerciseIntent = new Intent(ExerciseActivity.this, VideoActivity.class);
        exerciseIntent.putExtra("url",path);
        startActivity(exerciseIntent);
    }
}
