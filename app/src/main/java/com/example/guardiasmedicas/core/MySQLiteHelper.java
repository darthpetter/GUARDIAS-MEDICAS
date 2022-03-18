package com.example.guardiasmedicas.core;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String TABLE_ROLES="CREATE TABLE roles(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombres TEXT" +
            ");";

    private static final String TABLE_MEDICOS="CREATE TABLE medicos(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombres TEXT," +
            "apellidos TEXT," +
            "email TEXT,"+
            "rolID INTEGER," +
            "FOREIGN KEY(rolID) REFERENCES roles(_id));";

    private static final String TABLE_TURNOS="CREATE TABLE turnos(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "medicoId INTEGER" +
            "fechaHoraInicio DATETIME," +
            "fechaHoraSalida DATETIME," +
            "FOREIGN KEY(medicoId) REFERENCES medicos(_id));";

    private static final String TABLE_USERS="CREATE TABLE users(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "email TEXT UNIQUE NOT NULL," +
            "password TEXT NOT NULL" + //TODO añadir elementos hash para encriptar la clave o sino no
            ");";

    private static final String DB_NAME="hospital";
    private static final String TABLE_CREATE=TABLE_ROLES+TABLE_MEDICOS+TABLE_TURNOS+TABLE_USERS;
    private static final int DB_VERSION=1;

    public MySQLiteHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
