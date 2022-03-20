package com.example.guardiasmedicas.domain;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.guardiasmedicas.data.database.MySQLiteHelper;
import com.example.guardiasmedicas.data.model.Medico;
import com.example.guardiasmedicas.data.model.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MedicoController {
    private final Context context;

    public MedicoController(Context context){
        this.context=context;
    }

    public void insertOnDB(Medico medico){
        MySQLiteHelper sqlHelper=new MySQLiteHelper(context);
        SQLiteDatabase db=sqlHelper.getWritableDatabase();

        if(db!=null){
            db.insert("medicos",null,medico.getModeloInsercion());
        }
    }

    public List<Medico> getFromDB(){
        MySQLiteHelper sqlHelper=new MySQLiteHelper(context);
        SQLiteDatabase db=sqlHelper.getReadableDatabase();
        List<Medico> medicos= new LinkedList<Medico>(Arrays.asList());;
        if(db!=null){
            Cursor cursor=db.rawQuery("SELECT * FROM medicos",
                    null
            );

            if(cursor.getCount()>0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    Medico medico = new Medico(
                            cursor.getString(cursor.getColumnIndexOrThrow("nombres")),
                            cursor.getString(cursor.getColumnIndexOrThrow("apellidos")),
                            cursor.getString(cursor.getColumnIndexOrThrow("especializacion")),
                            cursor.getString(cursor.getColumnIndexOrThrow("email"))
                    );

                    System.out.println("nombres: "+medico.getNombres());
                    medicos.add(medico);
                    cursor.moveToNext();
                }
            }

        }
        return medicos;
    }
}
