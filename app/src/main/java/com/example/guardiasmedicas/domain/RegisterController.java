package com.example.guardiasmedicas.domain;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.guardiasmedicas.data.database.MySQLiteHelper;
import com.example.guardiasmedicas.data.model.User;

public class RegisterController {

    private static Context context;

    public static void registerUser(User user,Context rContext){
        context=rContext;

        MySQLiteHelper sqlHelper=new MySQLiteHelper(context);
        SQLiteDatabase db=sqlHelper.getWritableDatabase();

        if(db!=null){
            ContentValues cvUser=new ContentValues();
            cvUser.put("email",user.getEmail());
            cvUser.put("password",user.getPassword());

            checkEmail(user.getEmail());
            try{
                db.insert("users",null,cvUser);
            }catch(Exception e){

            }
        }
    }
    private static boolean checkEmail(String email){
        MySQLiteHelper sqlHelper=new MySQLiteHelper(context);
        SQLiteDatabase db=sqlHelper.getReadableDatabase();
        if(db!=null) {
            Cursor cursor = db.rawQuery("SELECT count(_id) as existe FROM users WHERE email ='" + email+"'",
                    null
            );

            cursor.moveToFirst();
            int exists=cursor.getInt(cursor.getColumnIndexOrThrow("existe"));

            if(exists>0){
                showError("Este E-mail ya ha sido registrado antes.");
                return false;
            }
        }
        return true;
    }

    private static void showError(String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }

}