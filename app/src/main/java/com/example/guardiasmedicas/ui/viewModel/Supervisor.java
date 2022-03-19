package com.example.guardiasmedicas.ui.viewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.guardiasmedicas.R;
import com.example.guardiasmedicas.databinding.ActivitySupervisorBinding;
import com.example.guardiasmedicas.ui.viewModel.AcercaNosotros;
import com.example.guardiasmedicas.ui.viewModel.Estadisticas;
import com.example.guardiasmedicas.ui.viewModel.Supervisor_Medicos;

public class Supervisor extends AppCompatActivity {
    private ActivitySupervisorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivitySupervisorBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
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
                Intent acercanos=new Intent(this, AcercaNosotros.class);
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
        Intent estadisticas_intent=new Intent(this, Estadisticas.class);
        startActivity(estadisticas_intent);
    }
    public void datos_medicos(View v){
        Intent intent=new Intent(this, Supervisor_Medicos.class);
        startActivity(intent);
    }
}