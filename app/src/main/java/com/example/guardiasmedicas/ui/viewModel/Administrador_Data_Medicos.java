package com.example.guardiasmedicas.ui.viewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.guardiasmedicas.R;
import com.example.guardiasmedicas.data.model.Medico;
import com.example.guardiasmedicas.databinding.ActivityAdministradorDataMedicosBinding;
import com.example.guardiasmedicas.domain.MedicoController;
import com.example.guardiasmedicas.ui.view.MedicoAdapter;
import com.example.guardiasmedicas.ui.view.MedicoRolAdapter;

import java.util.List;

public class Administrador_Data_Medicos extends AppCompatActivity {
    private ActivityAdministradorDataMedicosBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityAdministradorDataMedicosBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        MedicoController medicoController=new MedicoController(this);
        List<Medico> medicos=medicoController.getFromDB();

        if(medicos.size()>0){
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            binding.recyclerView.setAdapter(new MedicoRolAdapter(medicos, this));
        }
    }



}