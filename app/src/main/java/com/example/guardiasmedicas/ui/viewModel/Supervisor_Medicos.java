package com.example.guardiasmedicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Supervisor_Medicos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor_medicos);
    }
    public void nuevo_medico(View v){
        Intent intent=new Intent(this,Supervisor_Nuevo_Medico.class);
        finish();
        startActivity(intent);
    }
}