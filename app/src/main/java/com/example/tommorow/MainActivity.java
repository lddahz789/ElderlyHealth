package com.example.tommorow;


import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
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
public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

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
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    public int getContnetView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
//        backImageView.setVisibility(View.GONE);
        title.setText(R.string.mian);
        drawerLayout = (DrawerLayout) findViewById(R.id.left_drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        backImageView.setImageResource(R.drawable.ic_menu_white);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // display menu button
            actionBar.setDisplayHomeAsUpEnabled(true);
            // set menu icon
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white);
        }

    }

    @Override
    public void onClick(View v) {
        drawerLayout.openDrawer(Gravity.START);

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_about:

                Toast.makeText(this, "You press about!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        drawerLayout.closeDrawers();
        return true;
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
