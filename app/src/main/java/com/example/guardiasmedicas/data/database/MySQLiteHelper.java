package com.example.guardiasmedicas.data.database;

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
            "especializacion TEXT,"+
            "email TEXT"+
            ");";

    private static final String TABLE_TURNOS="CREATE TABLE turnos(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "medicoId INTEGER," +
            "fechaHoraInicio DATETIME," +
            "fechaHoraSalida DATETIME," +
            "FOREIGN KEY(medicoId) REFERENCES medicos(_id));";

    private static final String TABLE_USERS="CREATE TABLE users(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "email TEXT UNIQUE NOT NULL," +
            "password TEXT NOT NULL," + //TODO añadir elementos hash para encriptar la clave o sino no
            "rolID INTEGER," +
            "medicoID INTEGER," +
            "FOREIGN KEY(medicoID) REFERENCES medicos(_id)," +
            "FOREIGN KEY(rolID) REFERENCES roles(_id)" +
            ");";

    private static final String ALTER_TABLE_MEDICOS="ALTER TABLE medicos " +
            "ADD COLUMN userID INTEGER " +
            "REFERENCES users(_id);";

    private static final String INSERT_ROLES="INSERT INTO roles(_id,nombres) " +
            "VALUES(1,'ADMINISTRADOR')," +
            "(2,'SUPERVISOR')," +
            "(3,'PLANIFICADOR')," +
            "(4,'GENERAL');";

    private static final String INSERT_DEFAULTUSERS ="INSERT INTO users(email,password,rolID) " +
            "VALUES('administrador@hospital.com','admin123',1)," +
            "('supervisor@hospital.com','super123',2)," +
            "('planificador@hospital.com','plan123',3)";


    private static final String DB_NAME="hospital";
    private static final int DB_VERSION=1;

    public MySQLiteHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_MEDICOS);
        sqLiteDatabase.execSQL(TABLE_TURNOS);
        sqLiteDatabase.execSQL(TABLE_ROLES);
        sqLiteDatabase.execSQL(TABLE_USERS);
        sqLiteDatabase.execSQL(ALTER_TABLE_MEDICOS);
        sqLiteDatabase.execSQL(INSERT_ROLES);
        sqLiteDatabase.execSQL(INSERT_DEFAULTUSERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
