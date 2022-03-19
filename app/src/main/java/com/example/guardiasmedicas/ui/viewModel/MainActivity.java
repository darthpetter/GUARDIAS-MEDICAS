package com.example.guardiasmedicas.ui.viewModel;


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

import com.example.guardiasmedicas.R;
import com.example.guardiasmedicas.databinding.ActivityMainBinding;
import com.example.guardiasmedicas.domain.AuthController;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        /*

        SharedPreferences prefe=getSharedPreferences("datosUsuario",Context.MODE_PRIVATE);
        username.setText(prefe.getString("username",""));
        password.setText(prefe.getString("password",""));

         */
    }
    public void registrar(View v){
        Intent registro=new Intent(this, Registro.class);
        startActivity(registro);
    }
    public void ingresar(View v){
        if(verificarCampos()) {
            Toast.makeText(this, "Llene los campos del formulario", Toast.LENGTH_SHORT).show();
        }else{
            dialogSP();
            AuthController.authLogin(
                    binding.etUsername.getText().toString(),
                    binding.etPassword.getText().toString(),
                    this
            );
        }
    }
    public void limpiarCampos(){
        binding.etUsername.setText("");
        binding.etPassword.setText("");
    }
    public Boolean verificarCampos(){
        return binding.etUsername.getText().toString().isEmpty() &&
                binding.etPassword.getText().toString().isEmpty();
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
        editor.putString("username",binding.etUsername.getText().toString());
        editor.putString("password",binding.etPassword.getText().toString());
        editor.commit();
    }
    public void borrarSP(View v){
        SharedPreferences preferencias=getSharedPreferences("datosUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit().clear();
        editor.commit();
    }
}