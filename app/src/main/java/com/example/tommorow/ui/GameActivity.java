package com.example.tommorow.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.tommorow.BaseActivity;
import com.example.tommorow.Constant.Const;
import com.example.tommorow.MainActivity;
import com.example.tommorow.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/4/6.
 */

public class GameActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        title.setText(getResources().getString(R.string.game));
    }

    @Override
    public int getContnetView() {
        return R.layout.activity_game;
    }

    @OnClick({})
    public void onViewClicked(View view) {
        switch (view.getId()) {
//            case R.id.breakfast:
//                Intent breakfastIntent = new Intent(NutritionActivity.this, HistoryFoodListActivity.class);
//                breakfastIntent.putExtra(Const.TYPE, 1);
//                startActivity(breakfastIntent);
//                break;
        }
    }
}
