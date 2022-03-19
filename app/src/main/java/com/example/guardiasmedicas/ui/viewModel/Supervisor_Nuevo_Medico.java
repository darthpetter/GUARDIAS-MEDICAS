package com.example.guardiasmedicas.ui.viewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.guardiasmedicas.data.model.Medico;
import com.example.guardiasmedicas.databinding.ActivitySupervisorNuevoMedicoBinding;
import com.example.guardiasmedicas.domain.MedicoController;

public class Supervisor_Nuevo_Medico extends AppCompatActivity {
    private ActivitySupervisorNuevoMedicoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivitySupervisorNuevoMedicoBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
    }
    public void guardar(View v){
        if(!camposLlenos()) {
            Medico medico=new Medico(
                    binding.etNombres.getText().toString(),
                    binding.etApellidos.getText().toString(),
                    binding.etEmail.getText().toString(),
                    binding.etEspecializacion.getText().toString()
            );

            MedicoController controller=new MedicoController(this);
            controller.insertOnDB(medico);

            finish();
        }
        else
            Toast.makeText(this, "Por favor, llena todos los campos.\uD83E\uDD7A", Toast.LENGTH_SHORT).show();

    }
    public boolean camposLlenos(){
        return binding.etNombres.getText().toString().isEmpty() &&
                binding.etApellidos.getText().toString().isEmpty() &&
                binding.etEmail.getText().toString().isEmpty() &&
                binding.etEspecializacion.getText().toString().isEmpty();
    }
}