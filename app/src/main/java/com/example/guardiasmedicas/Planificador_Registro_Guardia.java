package com.example.guardiasmedicas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Planificador_Registro_Guardia extends AppCompatActivity {
    private Spinner sp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planificador_registro_guardia);

        sp1=findViewById(R.id.spinner);
        String Medicos[]={"Doctor Ivan Kaviedes","Doctor Juan Perez","Doctora Sufrida Pechiche"};
        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Medicos);
        sp1.setAdapter(adaptador);
    }
}