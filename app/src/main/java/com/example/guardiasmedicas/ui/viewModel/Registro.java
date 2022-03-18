package com.example.guardiasmedicas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    private EditText nombres, contraseña, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombres=findViewById(R.id.etNombresC);
        contraseña=findViewById(R.id.etContraseña);
        email=findViewById(R.id.etEmail1);
    }
    public void registrar(View v){
        if(campos()){
            Toast.makeText(this, "Registrando ;);)", Toast.LENGTH_SHORT).show();
            finish();
        }else
            Toast.makeText(this, "Por favor, llena todos los campos.\uD83E\uDD7A", Toast.LENGTH_SHORT).show();
    }
    public boolean campos(){
        if(nombres.getText().toString().isEmpty() && contraseña.getText().toString().isEmpty() && email.getText().toString().isEmpty())
            return false;
        else
            return true;
    }
}