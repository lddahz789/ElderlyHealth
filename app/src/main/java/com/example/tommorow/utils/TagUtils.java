package com.example.tommorow.utils;

import android.content.Context;

import com.example.tommorow.Constant.Const;

import java.util.Calendar;


/**
 * Created by lenovo on 2017/4/22.
 * Util class
 * obtain data then stored to SharePreferences
 */
public class TagUtils {

    public static  String getTag(int type, Context context) {
        String tag = getData(context);
        switch (type) {
            case 1:
                tag = tag + Const.BREAK_FAST;
                break;
            case 2:
                tag = tag + Const.LUNCK;
                break;
            case 3:
                tag = tag + Const.DINNER;
                break;
            default:
                break;
        }
        return tag;
    }

    public static String getData(Context context) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); //获取当前年份
        int mMonth = c.get(Calendar.MONTH);//获取当前月份
        int mDay = c.get(Calendar.DAY_OF_MONTH);//获取当前月份的日期号码
        return mYear + mMonth + mDay + SharedPreferencesUtil.getInstance(context).getString(Const.USER_NAME);
    }
}
