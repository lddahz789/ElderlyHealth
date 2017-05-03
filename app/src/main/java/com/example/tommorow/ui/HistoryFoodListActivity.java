package com.example.tommorow.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tommorow.BaseActivity;
import com.example.tommorow.Constant.Const;
import com.example.tommorow.R;
import com.example.tommorow.adapter.HistoryAdapter;
import com.example.tommorow.entity.FoodModel;
import com.example.tommorow.utils.SharedPreferencesUtil;
import com.example.tommorow.utils.TagUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 早中晚饭的列表信息页面
 */

public class HistoryFoodListActivity extends BaseActivity {
    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.empty)
    TextView empty;
    @BindView(R.id.add)
    TextView add;
    private int type;
    private HistoryAdapter historyAdapter;
    List<FoodModel> foodList = new ArrayList<>();

    @Override
    public int getContnetView() {
        return R.layout.activity_history_food;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        add.setVisibility(View.VISIBLE);
        type = getIntent().getIntExtra(Const.TYPE, 0);


        if (type == 1) {
            title.setText(getResources().getString(R.string.breakfast));
        } else if (type == 2) {
            title.setText(getResources().getString(R.string.lunch));
        } else {
            title.setText("Today's Food");
        }
    }

    @OnClick(R.id.add)
    public void onViewClicked() {
        Intent intent = new Intent(HistoryFoodListActivity.this, AddFoodActivity.class);
        intent.putExtra(Const.TYPE, type);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        foodList = SharedPreferencesUtil.getInstance(this).getList(TagUtils.getTag(type, this));
        empty.setVisibility(foodList.size() == 0 ? View.VISIBLE : View.GONE);
        historyAdapter = new HistoryAdapter(foodList, this, 1);
        listView.setAdapter(historyAdapter);
        historyAdapter.notifyDataSetChanged();
    }
}
