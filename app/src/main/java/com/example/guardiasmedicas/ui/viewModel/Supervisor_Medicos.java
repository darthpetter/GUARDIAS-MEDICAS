package com.example.guardiasmedicas.ui.viewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.guardiasmedicas.R;
import com.example.guardiasmedicas.data.model.Medico;
import com.example.guardiasmedicas.databinding.ActivitySupervisorBinding;
import com.example.guardiasmedicas.databinding.ActivitySupervisorMedicosBinding;
import com.example.guardiasmedicas.domain.MedicoController;
import com.example.guardiasmedicas.ui.view.MedicoAdapter;

import java.util.List;

public class Supervisor_Medicos extends AppCompatActivity {

    private ActivitySupervisorMedicosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivitySupervisorMedicosBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        MedicoController medicoController=new MedicoController(this);

        List<Medico> medicos=medicoController.getFromDB();
        if(medicos.size()>0) {
            binding.rvListadoMedicos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            binding.rvListadoMedicos.setAdapter(new MedicoAdapter(medicos, this));
        }
    }
    public void nuevo_medico(View v){
        Intent intent=new Intent(this, Supervisor_Nuevo_Medico.class);
        finish();
        startActivity(intent);
    }

}