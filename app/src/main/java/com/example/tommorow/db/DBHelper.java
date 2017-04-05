package com.example.tommorow.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "user.db";// 数据库名称；
    private static final int DATABASE_VERSION = 1;// 数据库版本号；

    public DBHelper(Context context) {
        // CursorFactory设置为null,使用默认值
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // 数据库第一次被创建时onCreate会被调用
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建一张用户表,包括主键自增长，用户名，密码，身高，体重，生日等；
        String sql = "CREATE TABLE IF NOT EXISTS user" +
                "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name VARCHAR(50)," +
                "childname VARCHAR(50)," +
                "password VARCHAR(20)," +
                "birthday VARCHAR(20)," +
                "weight VARCHAR(20)," +
                "gender VARCHAR(20));";
        db.execSQL(sql);
    }

    // 如果DATABASE_VERSION值被改为2,系统发现现有数据库版本不同,即会调用onUpgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("ALTER TABLE user ADD COLUMN other STRING");
    }
}
