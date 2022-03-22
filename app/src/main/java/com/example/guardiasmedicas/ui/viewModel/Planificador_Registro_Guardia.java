package com.example.guardiasmedicas.ui.viewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.guardiasmedicas.R;
import com.example.guardiasmedicas.data.model.Medico;
import com.example.guardiasmedicas.databinding.ActivityPlanificadorRegistroGuardiaBinding;
import com.example.guardiasmedicas.domain.MedicoController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Planificador_Registro_Guardia extends AppCompatActivity {
    private ActivityPlanificadorRegistroGuardiaBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityPlanificadorRegistroGuardiaBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        MedicoController medicoControl=new MedicoController(this);
        List<Medico> medicos=medicoControl.getFromDB();
        String medicosArray[] = new String[medicos.size()];


        for(int i=0;i<medicos.size();i++){
            medicosArray[i]=medicos.get(i).getNombres()+" "+medicos.get(i).getApellidos();
        }

        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,medicosArray);
        binding.spMedicos.setAdapter(adaptador);

    }
    public void guardar(View v){
        if(!verificar_campos()){
            Toast.makeText(this, "Guardia Almacenada Exitosamente!", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(this, "Por favor, llena todos los campos.\uD83E\uDD7A", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean verificar_campos(){
        return binding.edtHoraInicio.getText().toString().isEmpty() &&
                binding.etHoraFin.getText().toString().isEmpty() &&
                binding.etFechaInicio.getText().toString().isEmpty() &&
                binding.etFechaFin.getText().toString().isEmpty();
    }
}