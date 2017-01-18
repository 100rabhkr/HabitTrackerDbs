package com.dezlum.www.habittracker.data;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dezlum.www.habittracker.data.HabitContract.HabitEntry;
import com.dezlum.www.habittracker.data.HabitContract.UserEntry;
/**
 * Created by saurabh on 1/18/2017.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "habit.db";

    public HabitDbHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_HABIT_TABLE = "CREATE TABLE "+HabitEntry.TABLE_NAME+"("+ HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLUMN_HABIT_NAME+" TEXT NOT NULL, "+ HabitEntry.COLUMN_HABIT_MEDICINE +" INTEGER NOT NULL DEFAULT 0" + ");";
        db.execSQL(SQL_CREATE_HABIT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
