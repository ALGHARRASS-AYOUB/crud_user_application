package com.example.crud_school_application;

import android.provider.BaseColumns;

public class UserContract {

    public  static  final class UserEntry implements BaseColumns {

        public  static  final String TABLE_NAME="users";
        public  static  final String COLUMN_FNAME="users";
        public  static  final String COLUMN_LNAME="users";
        public  static  final String COLUMN_ROLE="users";

    }
}
