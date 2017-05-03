package com.example.tommorow.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.tommorow.BaseActivity;
import com.example.tommorow.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/5/3.
 */

public class HistoryActivity extends BaseActivity{
    private ListView list_history;
    private String[] mListTitle = { "03/05/2017", "01/05/2017"};
    private String[] mListStr = { "Calorie:1567Kcal,\nFat: 48g, \nCarbohydrates: 252g,\nProtein: 57g",
            "Calorie:\n2102Kcal,\nFat: 81g,\nCarbohydrates: 340g,\nProtein: 67g" };
    ArrayList<Map<String,Object>> mData= new ArrayList<Map<String,Object>>();

    @Override
    public int getContnetView() {
        return R.layout.activity_history;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        title.setText("My History");
        list_history = (ListView) findViewById(R.id.listViewHistory);

        int lengh = mListTitle.length;
        for(int i =0; i < lengh; i++) {
            Map<String,Object> item = new HashMap<String,Object>();
            item.put("title", mListTitle[i]);
            item.put("text", mListStr[i]);
            mData.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(this,mData,android.R.layout.simple_list_item_2,
                new String[]{"title","text"},new int[]{android.R.id.text1,android.R.id.text2});
        list_history.setAdapter(adapter);


        list_history.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position,
                                    long id) {
                Toast.makeText(HistoryActivity.this,"You have chosen：" + mListTitle[position] + "Conent："+mListStr[position], Toast.LENGTH_LONG).show();
            }
        });
    }
}
