package com.example.guardiasmedicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class Administrador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.acercade:
                Intent acercanos=new Intent(this,AcercaNosotros.class);
                startActivity(acercanos);
                return true;
            case R.id.salir:
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void estadisticas(View V){
        Intent estadisticas_intent=new Intent(this,Estadisticas.class);
        startActivity(estadisticas_intent);
    }
    public void adm_roles(View v){
        Intent intent=new Intent(this,Administrador_Data_Medicos.class);
        startActivity(intent);
    }

}