package com.example.guardiasmedicas.domain;



import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.guardiasmedicas.data.database.MySQLiteHelper;
import com.example.guardiasmedicas.ui.viewModel.Administrador;
import com.example.guardiasmedicas.ui.viewModel.Planificador;
import com.example.guardiasmedicas.ui.viewModel.Supervisor;

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

        if(cursor.getCount()==1){
            cursor.moveToFirst();

            String emailR = cursor.getString(cursor.getColumnIndexOrThrow("email"));
            String passwordR = cursor.getString(cursor.getColumnIndexOrThrow("password"));
            int rolId=cursor.getInt(cursor.getColumnIndexOrThrow("rolID"));

            if (email.equals(emailR) && password.equals(passwordR)) {
                rolChecker(rolId);
            }else {
                message("Credenciales no válidas.");
            }
        }else {
            message("Credenciales no encontradas.");
        }
    }

    private static void rolChecker(int rolId){
        if(rolId==1){
            context.startActivity(new Intent(context,Administrador.class));
        }else if(rolId==2){
            context.startActivity(new Intent(context, Supervisor.class));
        }else if(rolId==3){
            context.startActivity(new Intent(context, Planificador.class));
        }
    }

    public static void message(String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }
}
