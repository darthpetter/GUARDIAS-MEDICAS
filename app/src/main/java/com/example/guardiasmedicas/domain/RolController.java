package com.example.guardiasmedicas.domain;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.guardiasmedicas.data.database.MySQLiteHelper;

public class RolController {
    private Context context;

    public RolController(Context context){
        this.context=context;
    }

    public boolean asignarRol(int userID,int rolID){
        MySQLiteHelper sql=new MySQLiteHelper(context);
        SQLiteDatabase db=sql.getWritableDatabase();

        if(db!=null){
            ContentValues cv=new ContentValues();
            cv.put("rolID",rolID);


            db.update(
                    "users",
                    cv,
                    "_id="+userID,
                    null
            );
            return true;
        }

        return false;
    }
}
