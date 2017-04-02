package com.example.tommorow.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.example.tommorow.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户业务实现类：
 */
public class UserDBUtils {

    DBHelper helper = null;
    Context context;

    public UserDBUtils(Context context) {
        this.context = context;
        helper = new DBHelper(context);
    }

    public void regist(User user) {
        SQLiteDatabase database = null;
        try {
            String sql = "INSERT INTO user(name,childname,password,birthday) VALUES (?,?,?,?)";
            database = helper.getWritableDatabase();
            database.execSQL(
                    sql,
                    new Object[]{user.getName(), user.getChildName(),
                            user.getPassWord(), user.getBirthday()});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (database != null) {
                database.close();
            }
        }
    }



    public List<User> queryAllUser() {
        List<User> users = new ArrayList<>();
        SQLiteDatabase database = null;
        try {
            String sql = "SELECT * FROM user";
            database = helper.getReadableDatabase();
            Cursor cursor = database.rawQuery(sql, null);
            while (cursor.moveToNext()) {
                User u = new User();
                u.setName(cursor.getString(cursor
                        .getColumnIndex("name")));
                u.setChildName(cursor.getString(cursor
                        .getColumnIndex("childname")));
                u.setBirthday(cursor.getString(cursor
                        .getColumnIndex("birthday")));
                u.setPassWord(cursor.getString(cursor.getColumnIndex("password")));
                users.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (database != null) {
                database.close();
            }
        }
        return users;
    }
}
