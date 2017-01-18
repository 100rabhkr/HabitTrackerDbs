package com.dezlum.www.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by saurabh on 1/18/2017.
 */

public class UserDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "user.db";

    public UserDbHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_USER_TABLE = "CREATE TABLE "+ HabitContract.UserEntry.TABLE_NAME+"("+ HabitContract.UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitContract.UserEntry.COLUMN_USER_NAME+" TEXT NOT NULL, "+ HabitContract.UserEntry.COLUMN_USER_AGE +" INTEGER NOT NULL, "+ HabitContract.UserEntry.COLUMN_USER_GENDER
                +" INTEGER NOT NULL DEFAULT 0, "+HabitContract.UserEntry.COLUMN_USER_WEIGHT+ " INTEGER NOT NULL"+ ");";
        db.execSQL(SQL_CREATE_USER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
