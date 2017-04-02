package com.example.tommorow.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.tommorow.entity.FoodModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * SharedPreferencesUtil 工具类 保持数据
 */

public class SharedPreferencesUtil {
    private static final String SHARED_PATH = "profile";
    private static SharedPreferencesUtil instance;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context mContext;


    public static SharedPreferencesUtil getInstance(Context context) {
        if (instance == null) {
            synchronized (SharedPreferencesUtil.class) {
                if (instance == null) {
                    instance = new SharedPreferencesUtil(context);
                }
            }
        }
        return instance;
    }

    public SharedPreferencesUtil(Context mContext) {
        this.mContext = mContext;
        sharedPreferences = mContext.getSharedPreferences(SHARED_PATH, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void putString(String key, String value) {
        if (key != null && !key.equals("")) {
            editor.putString(key, value);
            editor.commit();
        }
    }

    public void putInt(String key, int value) {
        if (key != null && !key.equals("")) {
            editor.putInt(key, value);
            editor.commit();
        }
    }

    public void putBoolean(String key, boolean value) {
        if (key != null && !key.equals("")) {
            editor.putBoolean(key, value);
            editor.commit();
        }
    }

    public void putLong(String key, Long value) {
        if (key != null && !key.equals("")) {
            editor.putLong(key, value);
            editor.commit();
        }
    }

    public void putFloat(String key, float value) {
        if (key != null && !key.equals("")) {
            editor.putFloat(key, value);
            editor.commit();
        }
    }

    public void putList(String key, List list) {
        if (key != null && !key.equals("")) {
            Gson gson = new Gson();
            String json = gson.toJson(list);
            editor.putString(key, json);
            editor.commit();
        }
    }
    public List<FoodModel> getList(String key)
    {
        List<FoodModel> alterSamples = new ArrayList<FoodModel>();
        String json = sharedPreferences.getString(key, null);
        if (json != null)
        {
            Gson gson = new Gson();
            Type type = new TypeToken<List<FoodModel>>(){}.getType();
            alterSamples = gson.fromJson(json, type);
        }
        return alterSamples;
    }
    public String getString(String key) {
        if (key != null && !key.equals("")) {
            return sharedPreferences.getString(key, "");
        }
        return null;
    }

    public int getInt(String key) {
        if (key != null && !key.equals("")) {
            return sharedPreferences.getInt(key, 0);
        }
        return 0;
    }

    public float getFloat(String key) {
        if (key != null && !key.equals("")) {
            return sharedPreferences.getFloat(key, 0);
        }
        return 0;
    }

    public boolean getBoolean(String key) {
        if (key != null && !key.equals("")) {
            return sharedPreferences.getBoolean(key, false);
        }
        return false;
    }

    public long getLong(String key) {
        if (key != null && !key.equals("")) {
            return sharedPreferences.getLong(key, 0);
        }
        return 0;
    }

    public boolean contains(String key) {
        return sharedPreferences.contains(key);
    }

    public void remove(String key) {
        editor.remove(key);
        editor.commit();
    }

    public void clear() {
        editor.clear();
        editor.commit();
    }
}
