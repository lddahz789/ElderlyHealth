package com.example.tommorow.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
 * Created by lenovo on 2017/4/22.
 * Controller class, corresponding to layout file
 * Handle the history food list activity logic
 * Shows all history food list
 * Layout file name: activity_history_food.xml
 */
public class HistoryFoodListActivity extends BaseActivity {
    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.empty)
    TextView empty;
    @BindView(R.id.add)
    TextView add;
    @BindView(R.id.goToReport)
    Button goToReport;
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

    @OnClick({R.id.add,R.id.goToReport})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add:
                Intent intent = new Intent(HistoryFoodListActivity.this, AddFoodActivity.class);
                intent.putExtra(Const.TYPE, type);
                startActivity(intent);
                break;
            case R.id.goToReport:
                Intent analysisIntent = new Intent(HistoryFoodListActivity.this, AnalysisActivity.class);
                startActivity(analysisIntent);
                break;

        }

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
