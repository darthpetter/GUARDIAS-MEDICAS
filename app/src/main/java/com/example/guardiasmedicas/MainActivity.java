package com.example.guardiasmedicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.etUsername);
        password=findViewById(R.id.etPassword);
    }
    public void registrar(View v){

    }
    public void ingresar(View v){
        if(username.getText().toString().equals("administrador") && password.getText().toString().equals("admin123")){
            Toast.makeText(this, "Bienvenido Administrador", Toast.LENGTH_SHORT).show();
            Intent administrador_intent=new Intent(this,Administrador.class);
            startActivity(administrador_intent);
            limpiarCampos();
        }
        else if(username.getText().toString().equals("planificador") && password.getText().toString().equals("plan123")){
            Toast.makeText(this, "Bienvenido Planificador", Toast.LENGTH_SHORT).show();
            Intent planificador_intent=new Intent(this,Plafinicador.class);
            startActivity(planificador_intent);
            limpiarCampos();
        }
        else if(username.getText().toString().equals("supervisor") && password.getText().toString().equals("super123")){
            Toast.makeText(this, "Bienvenido Planificador", Toast.LENGTH_SHORT).show();
            Intent supervisor_intent=new Intent(this,Supervisor.class);
            startActivity(supervisor_intent);
            limpiarCampos();
        }
        else {
            Toast.makeText(this, "Acceso denegado, vuelve a intentarlo.", Toast.LENGTH_SHORT).show();
            password.setText("");
        }
    }
    public void limpiarCampos(){
        username.setText("");
        password.setText("");
    }
}