package com.example.guardiasmedicas.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guardiasmedicas.R;
import com.example.guardiasmedicas.data.model.Medico;
import com.example.guardiasmedicas.databinding.MedicoRolItemBinding;

import java.util.Collections;
import java.util.List;

public class MedicoRolAdapter extends RecyclerView.Adapter<MedicoRolAdapter.ViewHolder>{
    List<Medico> medicos= Collections.emptyList();
    private Context context;

    public MedicoRolAdapter(List<Medico> medicos,Context context){
        this.medicos=medicos;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new MedicoRolAdapter.ViewHolder(layoutInflater.inflate(R.layout.medico_rol_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Medico item=medicos.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return medicos.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private final MedicoRolItemBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=MedicoRolItemBinding.bind(itemView);
        }

        public void bind(Medico medico){
            binding.tvNombresMedico.setText(medico.getNombres()+""+medico.getApellidos());
            binding.etRolesUsuario.setText("no");
        }

    }
}
