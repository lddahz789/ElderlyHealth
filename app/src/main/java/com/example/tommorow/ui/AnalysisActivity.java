package com.example.tommorow.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.tommorow.BaseActivity;
import com.example.tommorow.Constant.Const;
import com.example.tommorow.R;
import com.example.tommorow.entity.RecommendFood;
import com.example.tommorow.utils.IntakeDataUtils;
import com.example.tommorow.utils.RecommendFoodUtils;
import com.example.tommorow.utils.SharedPreferencesUtil;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 分析的activity
 */

public class AnalysisActivity extends BaseActivity {

    @BindView(R.id.totalProtein)
    TextView totalProtein;
    @BindView(R.id.totalFat)
    TextView totalFat;
    @BindView(R.id.totalcarbohydrates)
    TextView totalcarbohydrates;
    @BindView(R.id.recommendProtein)
    TextView recommendProtein;
    @BindView(R.id.recommendFat)
    TextView recommendFat;
    @BindView(R.id.recommendCarbohydrates)
    TextView recommendCarbohydrates;
    @BindView(R.id.amountRecommendProtein)
    TextView amountRecommendProtein;
    @BindView(R.id.amountrecommendFat)
    TextView amountrecommendFat;
    @BindView(R.id.amountrecommendCarbohydrates)
    TextView amountrecommendCarbohydrates;
    @BindView(R.id.totalCalorie)
    TextView totalCalorie;
    @BindView(R.id.standardProtein)
    TextView standardProtein;
    @BindView(R.id.standardFat)
    TextView standardFat;
    @BindView(R.id.standarCarbon)
    TextView standardCarbon;
    @BindView(R.id.standardCalorie)
    TextView standardCalorie;

    private double[] data;

    @Override
    public int getContnetView() {
        return R.layout.activity_analysis;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        title.setText(getResources().getString(R.string.analysis));
        initData();
    }

    //初始化数据
    private void initData() {

        data = IntakeDataUtils.getInstance(this).calculation();
        totalFat.setText(changeDouble(data[0]) + "(g)");
        totalProtein.setText(changeDouble(data[1]) + "(g)");
        totalcarbohydrates.setText(changeDouble(data[2]) + "(g)");
        totalCalorie.setText(changeDouble((data[0] * 9) + (data[1] * 4) + ((data[2] * 4))) + "(Kcal)");

        initRecommendFood();
    }


    //double数据保留一位小数
    public double changeDouble(Double dou) {
        NumberFormat nf = new DecimalFormat("0.0 ");
        dou = Double.parseDouble(nf.format(dou));
        return dou;
    }

    //随机选择推荐食物
    private void initRecommendFood() {
        Double calorie = 30 * getWeight();
        Double sCarbon = calorie*0.55/4;
        Double sProtein = 60.0;
        Double sFat = calorie*0.28/9;

        standardProtein.setText("60(g)");
        standardCalorie.setText(changeDouble(calorie)+ "(Kcal)");
        standardCarbon.setText(changeDouble(calorie*0.55/4) + "(g)");
        standardFat.setText(changeDouble(calorie*0.28/9) + "(g)");
//        Toast.makeText(this, "tishi" + getDoubleAge() + "," + getWeight(), Toast.LENGTH_SHORT).show();
        double fat = sFat - changeDouble(data[0]);
        double protein = 60 - changeDouble(data[1]);
        double carbohydrates = sCarbon - changeDouble(data[2]);
        getRecommendCarbohydrates(carbohydrates);
        getRecommendFat(fat);
        getRecommendProtein(protein);
    }

    public Double getDoubleAge()
    {
        String strAge = String.valueOf(getAge());
        Double doubleAge = Double.parseDouble(strAge);
        return doubleAge;
    }

    public Double getWeight()
    {
        Double doubleWeight = 80.0;
        try {
            String strWeight = SharedPreferencesUtil.getInstance(this).getString(Const.WEIGHT);
            doubleWeight = Double.parseDouble(strWeight);
        } catch (Exception e) {

        }
        return doubleWeight;
}


    //To calculate age of user
    public int getAge() {
        Format f = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDay=null;
        try {
            birthDay= (Date) f.parseObject(SharedPreferencesUtil.getInstance(this).getString(Const.BIRTH));
        } catch (Exception e) {

        }

        Calendar cal = Calendar.getInstance();

        if (cal.before(birthDay)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth)
                    age--;
            } else {
                age--;
            }
        }
        return age;
    }



    private void getRecommendFat(double fat) {
        int status = -1;
        if (fat > 0 & fat < 10) {
            status = 0;
        } else if (fat > 10 & fat < 20) {
            status = 1;
        } else if (fat > 20 & fat < 30) {
            status = 2;
        } else if (fat > 30 & fat < 40) {
            status = 3;
        } else if (fat > 40 & fat < 50) {
            status = 4;
        } else if (fat > 50 & fat < 60) {
            status = 5;
        }
        List<List<RecommendFood>> lists = RecommendFoodUtils.getInstance().getRecommendFat();
        int num = 0 + (int) (Math.random() * (4 - 0 + 1));
        if (status != -1) {
            RecommendFood fatRecommend = lists.get(status).get(num);
            recommendFat.setText(fatRecommend.getName());
            amountrecommendFat.setText(getResources().getString(R.string.amount) + fatRecommend.getAmount()+("g"));
        }
        recommendFat.setVisibility(status == -1 ? View.GONE : View.VISIBLE);
        amountrecommendFat.setVisibility(status == -1 ? View.GONE : View.VISIBLE);
    }

    private void getRecommendCarbohydrates(double carbohydrates) {
        int status = -1;
        if (carbohydrates > 0 & carbohydrates < 25) {
            status = 0;
        } else if (carbohydrates > 25 & carbohydrates < 50) {
            status = 1;
        } else if (carbohydrates > 50 & carbohydrates < 75) {
            status = 2;
        } else if (carbohydrates > 75 & carbohydrates < 100) {
            status = 3;
        } else if (carbohydrates > 100 & carbohydrates < 125) {
            status = 4;
        } else if (carbohydrates > 125 & carbohydrates < 150) {
            status = 5;
        } else if (carbohydrates > 150 & carbohydrates < 175) {
            status = 6;
        } else if (carbohydrates > 175 & carbohydrates < 200) {
            status = 7;
        } else if (carbohydrates > 200 & carbohydrates < 225) {
            status = 8;
        } else if (carbohydrates > 225 & carbohydrates < 250) {
            status = 9;
        } else if (carbohydrates > 250 & carbohydrates < 275) {
            status = 10;
        } else if (carbohydrates > 275 & carbohydrates < 300) {
            status = 11;
        }
        List<List<RecommendFood>> lists = RecommendFoodUtils.getInstance().getRecommendCarbohydate();
        int num = 0 + (int) (Math.random() * (4 - 0 + 1));
        if (status != -1) {
            RecommendFood carbohydratesRecommend = lists.get(status).get(num);
            recommendCarbohydrates.setText(carbohydratesRecommend.getName());
            amountrecommendCarbohydrates.setText(getResources().getString(R.string.amount) + carbohydratesRecommend.getAmount()+("g"));
        }
        recommendCarbohydrates.setVisibility(status == -1 ? View.GONE : View.VISIBLE);
        amountrecommendCarbohydrates.setVisibility(status == -1 ? View.GONE : View.VISIBLE);
    }

    private void getRecommendProtein(double protein) {
        int status = -1;
        if (protein > 0 & protein < 10) {
            status = 0;
        } else if (protein > 10 & protein < 20) {
            status = 1;
        } else if (protein > 20 & protein < 30) {
            status = 2;
        } else if (protein > 30 & protein < 40) {
            status = 3;
        } else if (protein > 40 & protein < 50) {
            status = 4;
        } else if (protein > 50 & protein < 60) {
            status = 5;
        } else if (protein > 60 & protein < 70) {
            status = 6;
        } else if (protein > 70 & protein < 80) {
            status = 7;
        } else if (protein > 80 & protein < 90) {
            status = 8;
        } else if (protein > 90 & protein < 100) {
            status = 9;
        } else if (protein > 100 & protein < 110) {
            status = 10;
        } else if (protein > 110 & protein < 120) {
            status = 11;
        } else if (protein > 120 & protein < 130) {
            status = 12;
        } else if (protein > 130 & protein < 140) {
            status = 13;
        } else if (protein > 140 & protein < 150) {
            status = 14;
        } else if (protein > 150 & protein < 160) {
            status = 15;
        } else if (protein > 160 & protein < 170) {
            status = 16;
        } else if (protein > 170 & protein < 189) {
            status = 17;
        }
        List<List<RecommendFood>> lists = RecommendFoodUtils.getInstance().getRecommendProtein();
        int num = 0 + (int) (Math.random() * (4- 0 + 1));
        if (status != -1) {
            RecommendFood proteinRecommend = lists.get(status).get(num);
            recommendProtein.setText(proteinRecommend.getName());
            amountRecommendProtein.setText(getResources().getString(R.string.amount) + proteinRecommend.getAmount()+("g"));
        }
        recommendProtein.setVisibility(status == -1 ? View.GONE : View.VISIBLE);
        amountRecommendProtein.setVisibility(status == -1 ? View.GONE : View.VISIBLE);
    }
}

