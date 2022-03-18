package com.example.guardiasmedicas.domain;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.guardiasmedicas.core.MySQLiteHelper;

public class AuthController {
    private static Context context;


    public static void authLogin(String email, String password,Context rContext) {
        context = rContext;

        MySQLiteHelper sqlHelper = new MySQLiteHelper(context);
        SQLiteDatabase dbInstance = sqlHelper.getReadableDatabase();
        Cursor cursor = dbInstance.rawQuery(
                "SELECT * FROM users WHERE email='" + email + "' AND password='" + password + "' LIMIT 1",
                null
        );

        cursor.moveToFirst();

        String emailR = cursor.getString(cursor.getColumnIndexOrThrow("email"));
        String passwordR = cursor.getString(cursor.getColumnIndexOrThrow("password"));


        if (email.equals(emailR) && password.equals(passwordR)) {
            message("Coinciden");
        }else{
            message("Credenciales no válidas.");
        }
    }

    public static void message(String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }
}
