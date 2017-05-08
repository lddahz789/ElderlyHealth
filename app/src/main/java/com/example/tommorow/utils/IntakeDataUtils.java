package com.example.tommorow.utils;

import android.content.Context;

import com.example.tommorow.entity.FoodModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/4/22.
 * Util class
 * Reading excel util
 */
public class IntakeDataUtils {
    private static IntakeDataUtils instance;
    private Context context;

    public static IntakeDataUtils getInstance(Context context) {
        if (instance == null) {
            synchronized (IntakeDataUtils.class) {
                if (instance == null) {
                    instance = new IntakeDataUtils(context);
                }
            }
        }
        return instance;
    }

    public IntakeDataUtils(Context context) {
        this.context = context.getApplicationContext();
    }

    /**
     * @return
     */
    public double[] calculation() {
        double[] data = new double[3];
        double fat = 0;
        double protein = 0;
        double carbohydrates = 0;
        List<FoodModel> allFood = new ArrayList<>();
        List<FoodModel> breakFast = SharedPreferencesUtil.getInstance(context).getList(TagUtils.getTag(1, context));
        List<FoodModel> lunchFast = SharedPreferencesUtil.getInstance(context).getList(TagUtils.getTag(2, context));
        List<FoodModel> dinnerFast = SharedPreferencesUtil.getInstance(context).getList(TagUtils.getTag(3, context));
        allFood.addAll(breakFast);
        allFood.addAll(lunchFast);
        allFood.addAll(dinnerFast);

        for (FoodModel foodModel : allFood) {
            fat = fat + foodModel.getFat() * foodModel.getAmount() / 100;
            protein = protein + foodModel.getProtein() * foodModel.getAmount() / 100;
            carbohydrates = carbohydrates + foodModel.getCarbohydrates() * foodModel.getAmount() / 100;
        }
        data[0] = fat;
        data[1] = protein;
        data[2] = carbohydrates;
        return data;
    }

}
