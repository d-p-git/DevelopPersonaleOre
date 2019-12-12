package com.example.developpersonaleore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBManager extends SQLiteOpenHelper {

    public static  final String DATABASE_NAME = "DB";
    public static final int DATABASE_VERSION = 1;

    public DBManager(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, password TEXT)";
        db.execSQL(query);
    }
    public ArrayList<Bundle> getUsers(){
        ArrayList<Bundle> users = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM users";
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Bundle user = new Bundle();
            user.putInt("id",cursor.getInt(cursor.getColumnIndex("id")));
            user.putString("email",cursor.getString(cursor.getColumnIndex("email")));
            user.putString("password",cursor.getString(cursor.getColumnIndex("password")));
            users.add(user);
            cursor.moveToNext();
        }
        db.close();
        cursor.close();
        return users;
    }

    long insertUser(Bundle user){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("email", user.getString("email"));
        contentValues.put("password", user.getString("password"));

        long rowID = db.insert("users",null, contentValues);
        db.close();
        return rowID;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
