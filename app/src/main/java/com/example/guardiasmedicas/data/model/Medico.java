package com.example.guardiasmedicas.data.model;

import android.content.ContentValues;

public class Medico {
    private int id;
    private String nombres, apellidos,especializacion,email;
    private int userID;

    private ContentValues modeloInsercion=new ContentValues();

    public Medico(String nombres, String apellidos, String especializacion, String email) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.especializacion = especializacion;
        this.email = email;

        this.modeloInsercion.put("nombres",nombres);
        this.modeloInsercion.put("apellidos",apellidos);
        this.modeloInsercion.put("especializacion",especializacion);
        this.modeloInsercion.put("email",email);
    }

    public Medico(int id,String nombres, String apellidos, String especializacion, String email,int userID) {
        this.id=id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.especializacion = especializacion;
        this.email = email;
        this.userID=userID;

        this.modeloInsercion.put("_id",id);
        this.modeloInsercion.put("nombres",nombres);
        this.modeloInsercion.put("apellidos",apellidos);
        this.modeloInsercion.put("especializacion",especializacion);
        this.modeloInsercion.put("email",email);
        this.modeloInsercion.put("userID",userID);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        this.modeloInsercion.put("_id",id);
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
        this.modeloInsercion.put("userID",userID);
    }

    public ContentValues getModeloInsercion() {
        return modeloInsercion;
    }

    public void setModeloInsercion(ContentValues modeloInsercion) {
        this.modeloInsercion = modeloInsercion;
    }
}
