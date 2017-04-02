package com.example.tommorow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.tommorow.Constant.Const;
import com.example.tommorow.ui.AnalysisActivity;
import com.example.tommorow.ui.HelpActivity;
import com.example.tommorow.ui.HistoryFoodListActivity;
import com.example.tommorow.ui.SettingAlarmActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 主界面activity
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.breakfast)
    LinearLayout breakfast;
    @BindView(R.id.lunch)
    LinearLayout lunch;
    @BindView(R.id.dinner)
    LinearLayout dinner;
    @BindView(R.id.analysis)
    LinearLayout analysis;
    @BindView(R.id.alarm)
    LinearLayout alarm;
    @BindView(R.id.help)
    LinearLayout help;
    @BindView(R.id.map)
    LinearLayout map;
    @BindView(R.id.exercise)
    LinearLayout exercise;

    @Override
    public int getContnetView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        backImageView.setVisibility(View.GONE);
        title.setText(R.string.mian);
    }

    @OnClick({R.id.breakfast, R.id.lunch, R.id.dinner, R.id.analysis, R.id.alarm, R.id.help, R.id.map, R.id.exercise})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.breakfast:
                Intent breakfastIntent = new Intent(MainActivity.this, HistoryFoodListActivity.class);
                breakfastIntent.putExtra(Const.TYPE, 1);
                startActivity(breakfastIntent);
                break;
            case R.id.lunch:
                Intent lunchIntent = new Intent(MainActivity.this, HistoryFoodListActivity.class);
                lunchIntent.putExtra(Const.TYPE, 2);
                startActivity(lunchIntent);
                break;
            case R.id.dinner:
                Intent dinnerIntent = new Intent(MainActivity.this, HistoryFoodListActivity.class);
                dinnerIntent.putExtra(Const.TYPE, 3);
                startActivity(dinnerIntent);
                break;
            case R.id.analysis:
                Intent analysisIntent = new Intent(MainActivity.this, AnalysisActivity.class);
                startActivity(analysisIntent);
                break;

            //Iteration 1 暂时不做这些
            case R.id.alarm:
//                Intent alarmIntent = new Intent(MainActivity.this, SettingAlarmActivity.class);
//                startActivity(alarmIntent);
                Toast.makeText(MainActivity.this, "In Progress!", Toast.LENGTH_SHORT).show();
                break;
                case R.id.help:
//                Intent helpIntent = new Intent(MainActivity.this, HelpActivity.class);
//                startActivity(helpIntent);
                    Toast.makeText(MainActivity.this, "In Progress!", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.map:
//                Intent mapIntent = new Intent(MainActivity.this, MapActivity.class);
//                startActivity(mapIntent);
                Toast.makeText(MainActivity.this, "In Progress!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exercise:
//            Intent exerciseIntent = new Intent(MainActivity.this, ExerciseActivity.class);
//            startActivity(exerciseIntent);
                Toast.makeText(MainActivity.this, "In Progress!", Toast.LENGTH_SHORT).show();
            break;
        }
    }

    private void toFoodHistory() {
        Intent alarmIntent = new Intent(MainActivity.this, HistoryFoodListActivity.class);
        startActivity(alarmIntent);
    }
}
