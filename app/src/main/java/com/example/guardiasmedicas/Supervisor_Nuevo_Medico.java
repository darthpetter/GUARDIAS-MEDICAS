package com.example.guardiasmedicas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Supervisor_Nuevo_Medico extends AppCompatActivity {
    private EditText etNombres, etApellidos, etEspecializacion, etEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor_nuevo_medico);
        etNombres=findViewById(R.id.etNombres);
        etApellidos=findViewById(R.id.etApellidos);
        etEspecializacion=findViewById(R.id.etEspecializacion);
        etEmail=findViewById(R.id.etEmail);
    }
    public void guardar(View v){
        if(camposLlenos()==1) {
            Toast.makeText(this, "Nuevo médico agregado al registro.", Toast.LENGTH_SHORT).show();
            finish();
        }
        else
            Toast.makeText(this, "Por favor, llena todos los campos.\uD83E\uDD7A", Toast.LENGTH_SHORT).show();

    }
    public int camposLlenos(){
        if(etNombres.getText().toString().equals("") || etNombres.getText().toString().equals("") || etNombres.getText().toString().equals("") || etNombres.getText().toString().equals(""))
            return 0;
        else
            return 1;
    }
}