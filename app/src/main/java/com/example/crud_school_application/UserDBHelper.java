package com.example.crud_school_application;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class UserDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="usersdb.db";
    private static final int DATABASE_VERSION=1;


    public UserDBHelper(@Nullable Context context) {
        super(context,DATABASE_NAME, null,DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String REQ=String.format("CREATE TABLE %s( %s INTEGER PRIMARY KEY,%s TEXT, %s TEXT, %s TEXT)",
                UserContract.UserEntry.TABLE_NAME,
                UserContract.UserEntry._ID,
                UserContract.UserEntry.COLUMN_FNAME,
                UserContract.UserEntry.COLUMN_LNAME,
                UserContract.UserEntry.COLUMN_ROLE
                );
        db.execSQL(REQ);
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        onCreate(db);
    }

    public void insertUser(User u){
       SQLiteDatabase DB=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(UserContract.UserEntry.COLUMN_FNAME,u.getFname());
        cv.put(UserContract.UserEntry.COLUMN_LNAME,u.getLname());
        cv.put(UserContract.UserEntry.COLUMN_ROLE,u.getRole());
        DB.insert(UserContract.UserEntry.TABLE_NAME,null,cv);
    }

    public void updateUser(User u){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(UserContract.UserEntry.COLUMN_FNAME,u.getFname());
        cv.put(UserContract.UserEntry.COLUMN_LNAME,u.getLname());
        cv.put(UserContract.UserEntry.COLUMN_ROLE,u.getRole());
        db.update(UserContract.UserEntry.TABLE_NAME,cv,"id=?",new String[] {String.valueOf(u.getId())});

    }

    public  void deleteUser(User u){

        SQLiteDatabase db=getWritableDatabase();
        db.delete(UserContract.UserEntry.TABLE_NAME,"id=?",new String[]{ String.valueOf(u.getId())});

    }

public ArrayList<User> getAllUsers(){
    SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery(String.format("SELECT * FROM %s ",UserContract.UserEntry.TABLE_NAME),null);

        ArrayList<User> users=new ArrayList<User>();
        if(c.moveToFirst()){
            do {
                User u=new User(c.getInt(0),c.getString(1),c.getString(2), c.getString(3));
                users.add(u);
            }while (c.moveToNext());
        }
        return  users;
    }
}
