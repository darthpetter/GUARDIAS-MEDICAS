package com.example.guardiasmedicas.data.model;

import android.util.ArrayMap;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class User{

    private String email, password;
    private int rolID, id;


    public User(int id,String email, String password, int rolID) {
        this.id=id;
        this.email = email;
        this.password = password;
        this.rolID = rolID;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRolID() {
        return rolID;
    }

    public void setRolID(int rolID) {
        this.rolID = rolID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
