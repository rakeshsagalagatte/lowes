package com.example.lowes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "Login.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(username text primary key,email text,phone number,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists user");
    }

    public boolean insert(String uname,String email,int phone,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",uname);
        contentValues.put("email",email);
        contentValues.put("phone",phone);
        contentValues.put("password",password);
        long ins = db.insert("user",null,contentValues);
        if(ins == -1) return false;
        else
            return true;
    }
    public Boolean chkuname(String uname) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where username=?",new String[]{uname});
        if(cursor.getCount()>0) return false;
        else return true;
    }
}
