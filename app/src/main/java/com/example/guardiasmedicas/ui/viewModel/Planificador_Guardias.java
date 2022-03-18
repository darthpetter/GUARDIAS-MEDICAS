package com.example.guardiasmedicas.ui.viewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.guardiasmedicas.R;

public class Planificador_Guardias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planificador_guardias);
    }
    public void registrar_guardia(View v){
        Intent intent=new Intent(this, Planificador_Registro_Guardia.class);
        startActivity(intent);
    }
}