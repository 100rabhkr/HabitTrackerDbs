package com.dezlum.www.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dezlum.www.habittracker.data.HabitContract;
import com.dezlum.www.habittracker.data.HabitDbHelper;
import com.dezlum.www.habittracker.data.UserDbHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InsertUserDB();
        InsertHabitDB();

    }

    private void InsertUserDB(){

        UserDbHelper mUDbHelper = new UserDbHelper(this);
        SQLiteDatabase sqLiteDatabase = mUDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitContract.UserEntry.COLUMN_USER_NAME,"Example Name");
        values.put(HabitContract.UserEntry.COLUMN_USER_AGE,10);
        values.put(HabitContract.UserEntry.COLUMN_USER_GENDER,HabitContract.UserEntry.GENDER_UNKNOWN);
        values.put(HabitContract.UserEntry.COLUMN_USER_WEIGHT,10);
        long newRowId = sqLiteDatabase.insert(HabitContract.UserEntry.TABLE_NAME,null,values);
        ReadUserDB();
    }

    private void ReadUserDB(){
        UserDbHelper mUDbHelper = new UserDbHelper(this);
        SQLiteDatabase sqLiteDatabase = mUDbHelper.getReadableDatabase();
        String[] projection={HabitContract.UserEntry._ID, HabitContract.UserEntry.COLUMN_USER_NAME, HabitContract.UserEntry.COLUMN_USER_AGE
        , HabitContract.UserEntry.COLUMN_USER_GENDER, HabitContract.UserEntry.COLUMN_USER_WEIGHT};
        String selection = HabitContract.UserEntry.COLUMN_USER_GENDER + "=?";
        String[] selectionArgs = new String[]{String.valueOf(HabitContract.UserEntry.GENDER_UNKNOWN)};
        Cursor cursor = sqLiteDatabase.query(HabitContract.UserEntry.TABLE_NAME,projection,
                selection, selectionArgs,
                null, null, null);
        try {

            TextView displayView = (TextView) findViewById(R.id.displayinfo);
            String td = "Number of rows in user database table: " + cursor.getCount()+"\n";
            displayView.setText(td);
            displayView.append(HabitContract.UserEntry._ID+" - "+ HabitContract.UserEntry.COLUMN_USER_NAME + " - " + HabitContract.UserEntry.COLUMN_USER_AGE
            +" - "+ HabitContract.UserEntry.COLUMN_USER_GENDER + " - "+ HabitContract.UserEntry.COLUMN_USER_WEIGHT);

            int idColumnIndex = cursor.getColumnIndex(HabitContract.UserEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(HabitContract.UserEntry.COLUMN_USER_NAME);
            int ageColumnIndex = cursor.getColumnIndex(HabitContract.UserEntry.COLUMN_USER_AGE);
            int genderColumnIndex = cursor.getColumnIndex(HabitContract.UserEntry.COLUMN_USER_GENDER);
            int weightColumnIndex = cursor.getColumnIndex(HabitContract.UserEntry.COLUMN_USER_WEIGHT);
            while (cursor.moveToNext()) {
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                int currentAge = cursor.getInt(ageColumnIndex);
                int currentGender = cursor.getInt(genderColumnIndex);
                String Gender;
                if(currentGender == HabitContract.UserEntry.GENDER_UNKNOWN){
                    Gender = "Unknown";
                }
                else if(currentGender == HabitContract.UserEntry.GENDER_MALE){
                    Gender = "Male";
                }
                else {
                    Gender = "Female";
                }
                int currentWeight = cursor.getInt(weightColumnIndex);
                displayView.append(("\n" + currentID + " - " +
                        currentName + " - " + currentAge + " - "+ Gender + " - " + currentWeight));

            }

        }finally {
            cursor.close();
        }
    }

    private void InsertHabitDB(){
        HabitDbHelper mHDbHelper = new HabitDbHelper(this);
        SQLiteDatabase sqLiteDatabase = mHDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_NAME,"Running");
        values.put(HabitContract.HabitEntry.COLUMN_HABIT_MEDICINE, HabitContract.HabitEntry.MEDICINE_UNKNOWN);
        long newRowId = sqLiteDatabase.insert(HabitContract.HabitEntry.TABLE_NAME,null,values);
       ReadHabitDB();
    }

    private void ReadHabitDB(){
        HabitDbHelper mHDbHelper = new HabitDbHelper(this);
        SQLiteDatabase sqLiteDatabase = mHDbHelper.getReadableDatabase();
        String[] projection={HabitContract.HabitEntry._ID, HabitContract.HabitEntry.COLUMN_HABIT_NAME,
                HabitContract.HabitEntry.COLUMN_HABIT_MEDICINE};
        String selection = HabitContract.HabitEntry.COLUMN_HABIT_MEDICINE+"=?";
        String[] selectionArgs = new String[]{String.valueOf(HabitContract.HabitEntry.MEDICINE_UNKNOWN)};
        Cursor cursor = sqLiteDatabase.query(HabitContract.HabitEntry.TABLE_NAME,projection,
                selection, selectionArgs,
                null, null, null);
        try{
            TextView displayView = (TextView) findViewById(R.id.textView);
            String td = "Number of rows in habit database table: " + cursor.getCount()+"\n";
            displayView.setText(td);
            displayView.append(HabitContract.HabitEntry._ID + " - "+ HabitContract.HabitEntry.COLUMN_HABIT_NAME +
                    HabitContract.HabitEntry.COLUMN_HABIT_MEDICINE);
            int idindex = cursor.getColumnIndex(HabitContract.HabitEntry._ID);
            int habitindex = cursor.getColumnIndex(HabitContract.HabitEntry.COLUMN_HABIT_NAME);
            int medicineindex = cursor.getColumnIndex(HabitContract.HabitEntry.COLUMN_HABIT_MEDICINE);
            while (cursor.moveToNext()) {
                int currentID = cursor.getInt(idindex);
                String currentHoby = cursor.getString(habitindex);
                int currentMedicine = cursor.getInt(medicineindex);
                String med;
                if(currentMedicine == HabitContract.HabitEntry.MEDICINE_NO){
                    med = "No";
                }
                else if (currentMedicine == HabitContract.HabitEntry.MEDICINE_YES){
                    med= "Yes";
                }
                else {
                    med = "Unknown";
                }

                displayView.append(("\n" + currentID + " - " + currentHoby + " - " + med));

            }


        }
        finally {
            cursor.close();
        }
    }

}
