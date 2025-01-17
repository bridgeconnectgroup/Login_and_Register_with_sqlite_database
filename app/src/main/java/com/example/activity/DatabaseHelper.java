package com.example.activity;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(@Nullable Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table user(email text primary key, password text, name text, address text, gender text, status text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }
    //inserting database
    public boolean insert(String email, String password, String s3, String name, String address, String gender, String status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password",password);
        contentValues.put("name",name);
        contentValues.put("address",address);
        contentValues.put("gender",gender);
        contentValues.put("status",status);
        long ins = db.insert("user",null,contentValues);
        if (ins==-1) return false;
        else return true;
    }
    public Boolean chkemail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=?", new String[]{email});
        if(cursor.getCount()>0) return false;
        else return true;
    }
    //checking the email and password;
    public Boolean emailpassword(String email, String password){
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from user where email=? and password=?", new String[]{email,password});
            if(cursor.getCount()>0) return true;
            else return false;
    }
}
