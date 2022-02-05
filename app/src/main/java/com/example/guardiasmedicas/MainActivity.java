package com.example.guardiasmedicas;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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

        SharedPreferences prefe=getSharedPreferences("datosUsuario",Context.MODE_PRIVATE);
        username.setText(prefe.getString("username",""));
        password.setText(prefe.getString("password",""));
    }
    public void registrar(View v){
        Intent registro=new Intent(this,Registro.class);
        startActivity(registro);
    }
    public void ingresar(View v){
        if(verificarCampos()) {
            Toast.makeText(this, "Llene los campos del formulario", Toast.LENGTH_SHORT).show();
        }else{
            dialogSP();
            if (username.getText().toString().equals("administrador") && password.getText().toString().equals("admin123")) {
                Toast.makeText(this, "Bienvenido Administrador", Toast.LENGTH_SHORT).show();
                Intent administrador_intent = new Intent(this, Administrador.class);
                startActivity(administrador_intent);
                limpiarCampos();
            } else if (username.getText().toString().equals("planificador") && password.getText().toString().equals("plan123")) {
                Toast.makeText(this, "Bienvenido Planificador", Toast.LENGTH_SHORT).show();
                Intent planificador_intent = new Intent(this, Plafinicador.class);
                startActivity(planificador_intent);
                limpiarCampos();
            } else if (username.getText().toString().equals("supervisor") && password.getText().toString().equals("super123")) {
                Toast.makeText(this, "Bienvenido Supervisor", Toast.LENGTH_SHORT).show();
                Intent supervisor_intent = new Intent(this, Supervisor.class);
                startActivity(supervisor_intent);
                limpiarCampos();
            }else{
                Toast.makeText(this, "Acceso denegado. Vuelve a intentarlo.", Toast.LENGTH_SHORT).show();
                password.setText("");
            }
        }
    }
    public void limpiarCampos(){
        username.setText("");
        password.setText("");
    }
    public Boolean verificarCampos(){
        return username.getText().toString().equals("") && password.getText().toString().equals("");
    }
    public void dialogSP(){
        new AlertDialog.Builder(this,R.style.CustomDialogTheme)
                .setTitle("¿Deseas mantener sesión activa?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        guardarSP();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("MainActivity", "Aborting mission...");
                    }
                }).show();
    }

    public void guardarSP() {
        SharedPreferences preferencias=getSharedPreferences("datosUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();
        editor.putString("username",username.getText().toString());
        editor.putString("password",username.getText().toString());
        editor.commit();
    }
    public void borrarSP(View v){
        SharedPreferences preferencias=getSharedPreferences("datosUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit().clear();
        editor.commit();
    }
}