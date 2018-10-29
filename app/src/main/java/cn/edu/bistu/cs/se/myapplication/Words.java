package cn.edu.bistu.cs.se.myapplication;

import android.provider.BaseColumns;

public class Words {

    public Words(){

    }
    public static abstract class Word implements BaseColumns{
        public static final String TABLE_NAME = " notes ";

        public static final String CONTENT = " content ";

        public static final String ID = " _id ";

        public static final String TIME = " time ";
    }
}
