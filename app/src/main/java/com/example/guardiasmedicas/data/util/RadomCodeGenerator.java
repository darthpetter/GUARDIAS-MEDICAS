package com.example.guardiasmedicas.data.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.guardiasmedicas.data.database.MySQLiteHelper;

public class RadomCodeGenerator {
    private String TABLE_NAME;
    private Context context;

    public RadomCodeGenerator(String TABLE_NAME, Context context) {
        this.TABLE_NAME = TABLE_NAME;
        this.context = context;
    }

    public int generate(){
        int number=(int) (Math.random()*777)+1;

        if(check(number)){
            return number;
        }else{
            return generate();
        }
    }

    private boolean check(int number){
        MySQLiteHelper sql=new MySQLiteHelper(context);
        SQLiteDatabase db=sql.getReadableDatabase();

        if(db!=null){
            Cursor c=db.rawQuery(
                    "SELECT count(_id) as existencia FROM "+TABLE_NAME+" WHERE _id="+number+" LIMIT 1;",
                    null
            );
            c.moveToFirst();

            if(c.getInt(c.getColumnIndexOrThrow("existencia"))==0){
                return true;
            }
        }
        return false;
    }
}
