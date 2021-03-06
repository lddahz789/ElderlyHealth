package com.example.tommorow.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.tommorow.BaseActivity;
import com.example.tommorow.Constant.Const;
import com.example.tommorow.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/4/22.
 * Controller class, corresponding to layout file
 * Handle map nutrition logic
 * Navigation to three child elements
 * Layout file name: activity_nutrition.xml
 */
public class NutritionActivity extends BaseActivity {
//    @BindView(R.id.breakfast)
//    LinearLayout breakfast;
//    @BindView(R.id.lunch)
//    LinearLayout lunch;
    @BindView(R.id.dinner)
    LinearLayout dinner;
    @BindView(R.id.analysis)
    LinearLayout analysis;
    @BindView(R.id.history)
    LinearLayout history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        title.setText(getResources().getString(R.string.nutrition));
    }

    @Override
    public int getContnetView() {
        return R.layout.activity_nutrition;
    }

    @OnClick({R.id.dinner, R.id.analysis, R.id.history})
    public void onViewClicked(View view) {
        switch (view.getId()) {
//            case R.id.breakfast:
//                Intent breakfastIntent = new Intent(NutritionActivity.this, HistoryFoodListActivity.class);
//                breakfastIntent.putExtra(Const.TYPE, 1);
//                startActivity(breakfastIntent);
//                break;
//            case R.id.lunch:
//                Intent lunchIntent = new Intent(NutritionActivity.this, HistoryFoodListActivity.class);
//                lunchIntent.putExtra(Const.TYPE, 2);
//                startActivity(lunchIntent);
//                break;
            case R.id.dinner:
                Intent dinnerIntent = new Intent(NutritionActivity.this, HistoryFoodListActivity.class);
                dinnerIntent.putExtra(Const.TYPE, 3);
                startActivity(dinnerIntent);
                break;
            case R.id.analysis:
                Intent analysisIntent = new Intent(NutritionActivity.this, AnalysisActivity.class);
                startActivity(analysisIntent);
                break;
            case R.id.history:
                Intent historyIntent = new Intent(NutritionActivity.this, HistoryActivity.class);
                startActivity(historyIntent);
                break;
        }
    }
}
