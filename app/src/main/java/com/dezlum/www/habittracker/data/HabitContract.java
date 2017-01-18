package com.dezlum.www.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by saurabh on 1/18/2017.
 */

public class HabitContract {

    private HabitContract(){

    }

    public static final class UserEntry implements BaseColumns{

        public final static String TABLE_NAME = "user";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_USER_NAME = "name";
        public final static String COLUMN_USER_AGE = "age";
        public final static String COLUMN_USER_GENDER = "gender";
        public final static String COLUMN_USER_WEIGHT = "weight";

        public final static int GENDER_UNKNOWN = 0;
        public final static int GENDER_MALE=1;
        public final static int GENDER_FEMALE=2;

    }

    public static final class HabitEntry implements BaseColumns{
        public final static String TABLE_NAME = "user";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_HABIT_NAME = "misc_act";
        public final static String COLUMN_HABIT_MEDICINE = "medicine";

        public final static int MEDICINE_UNKNOWN = 0;
        public final static int MEDICINE_YES=1;
        public final static int MEDICINE_NO=2;
    }


}
