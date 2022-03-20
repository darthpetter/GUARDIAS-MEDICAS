package com.example.guardiasmedicas.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guardiasmedicas.R;
import com.example.guardiasmedicas.data.model.Medico;
import com.example.guardiasmedicas.databinding.MedicoItemBinding;

import java.util.Collections;
import java.util.List;

public class MedicoAdapter extends RecyclerView.Adapter<MedicoAdapter.ViewHolder> {
    List<Medico> medicos= Collections.emptyList();
    private Context context;

    public MedicoAdapter(List<Medico> medicos,Context context){
        this.medicos=medicos;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(layoutInflater.inflate(R.layout.medico_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Medico item=medicos.get(position);
        holder.bind(item,context);
    }

    @Override
    public int getItemCount() {
        return medicos.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private final View view;
        private final MedicoItemBinding binding;

        public ViewHolder(View view) {
            super(view);
            this.view=view;
            binding=MedicoItemBinding.bind(view);
        }

        public void bind(Medico medico, Context context){
            binding.etNombre.setText(medico.getNombres()+" "+medico.getApellidos());
            binding.etEspecialidad.setText(medico.getEspecializacion());
            binding.etCorreoE.setText(medico.getEmail());
        }
    }
}