package com.example.tommorow.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * DBHelper class
 *
 */
public class DBHelper extends SQLiteOpenHelper {

    //name of database
    private static final String DATABASE_NAME = "user.db";
    //version number of db
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        // CursorFactory setting = null,default value
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // invoked when first opening db
    @Override
    public void onCreate(SQLiteDatabase db) {
        // create a table
        String sql = "CREATE TABLE IF NOT EXISTS user" +
                "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name VARCHAR(50)," +
                "childname VARCHAR(50)," +
                "password VARCHAR(20)," +
                "birthday VARCHAR(20)," +
                "weight VARCHAR(20)," +
                "gender VARCHAR(20)," +
                "fullname VARCHAR(20));";
        db.execSQL(sql);
    }

    // if the value of DATABASE_VERSION is 2, invoke this method
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("ALTER TABLE user ADD COLUMN other STRING");
    }



}
