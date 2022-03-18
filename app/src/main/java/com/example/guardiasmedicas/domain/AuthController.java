package com.example.guardiasmedicas.domain;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.guardiasmedicas.core.MySQLiteHelper;

public class AuthController {
    private Context context;
    private final MySQLiteHelper sqlHelper;

    public AuthController(Context context) {
        this.context = context;
        sqlHelper=new MySQLiteHelper(context);
    }

    private void checkRol(){
        SQLiteDatabase dbInstance=sqlHelper.getReadableDatabase();


    }

    private boolean authLogin(String email, String password){
        SQLiteDatabase dbInstance=sqlHelper.getReadableDatabase();
        Cursor cursor= dbInstance.rawQuery("SELECT * FROM users WHERE email="+email+"&& password="+password,
                null);


        return true;
    }
}
