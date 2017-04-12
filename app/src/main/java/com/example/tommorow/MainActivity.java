package com.example.tommorow;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tommorow.Constant.Const;
import com.example.tommorow.ui.HelpActivity;
import com.example.tommorow.ui.HistoryFoodListActivity;
import com.example.tommorow.ui.MapsActivity;
import com.example.tommorow.ui.NutritionActivity;
import com.example.tommorow.ui.SettingActivity;
import com.example.tommorow.ui.SettingAlarmActivity;
import com.example.tommorow.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 主界面activity
 */
public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.nutrition)
    LinearLayout nutrition;
    @BindView(R.id.game)
    LinearLayout game;
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
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            // display menu button
//            actionBar.setDisplayHomeAsUpEnabled(true);
//            // set menu icon
//            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white);
//        }

    }

    @Override
    public void onClick(View v) {

        drawerLayout.openDrawer(Gravity.START);
        TextView fullNameOnSideA =(TextView) findViewById(R.id.fullNameOnSide);
        fullNameOnSideA.setText(SharedPreferencesUtil.getInstance(this).getString(Const.FULLNAME));
    }

    //close side menu when pressed back button
    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(navigationView)){
            drawerLayout.closeDrawers();
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_profile:

                Toast.makeText(this, "You press profile!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_nutrition:
                Intent nutritionIntent = new Intent(MainActivity.this, NutritionActivity.class);
                startActivity(nutritionIntent);
                break;

            case R.id.nav_emergency:
                Intent helpIntent = new Intent(MainActivity.this, HelpActivity.class);
                startActivity(helpIntent);
                break;

            case R.id.nav_reminder:
                Intent alarmIntent = new Intent(MainActivity.this, SettingAlarmActivity.class);
                startActivity(alarmIntent);
                break;

            case R.id.nav_maps:
                Intent mapIntent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(mapIntent);
                break;

            case R.id.nav_excercise:
                Toast.makeText(MainActivity.this, "In Progress, will deliver in Iteration 3!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_game:
                Toast.makeText(MainActivity.this, "In Progress, will deliver in Iteration 3!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_setting:
                Intent settingIntent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(settingIntent);
                break;

            case R.id.nav_about:
                Toast.makeText(this, "You press about!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        drawerLayout.closeDrawers();
        return true;
    }




    @OnClick({R.id.nutrition,R.id.game, R.id.alarm, R.id.help, R.id.map, R.id.exercise})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.nutrition:
                Intent nutritionIntent = new Intent(MainActivity.this, NutritionActivity.class);
                startActivity(nutritionIntent);
                break;

            case R.id.game:
//                Intent gameIntent = new Intent(MainActivity.this, GameActivity.class);
//                startActivity(gameIntent);
                Toast.makeText(MainActivity.this, "In Progress, will deliver in Iteration 3!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.alarm:
                Intent alarmIntent = new Intent(MainActivity.this, SettingAlarmActivity.class);
                startActivity(alarmIntent);
//                Toast.makeText(MainActivity.this, "In Progress!", Toast.LENGTH_SHORT).show();
                break;
                case R.id.help:
                Intent helpIntent = new Intent(MainActivity.this, HelpActivity.class);
                startActivity(helpIntent);
//                    Toast.makeText(MainActivity.this, "In Progress!", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.map:
                Intent mapIntent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(mapIntent);
                break;
            case R.id.exercise:
//            Intent exerciseIntent = new Intent(MainActivity.this, ExerciseActivity.class);
//            startActivity(exerciseIntent);
                Toast.makeText(MainActivity.this, "In Progress, will deliver in Iteration 3!", Toast.LENGTH_SHORT).show();
            break;
        }
    }

    private void toFoodHistory() {
        Intent alarmIntent = new Intent(MainActivity.this, HistoryFoodListActivity.class);
        startActivity(alarmIntent);
    }
}
