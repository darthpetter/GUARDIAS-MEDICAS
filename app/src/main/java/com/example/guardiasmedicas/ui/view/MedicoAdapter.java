package com.example.guardiasmedicas.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.opengl.Visibility;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guardiasmedicas.R;
import com.example.guardiasmedicas.data.model.Medico;
import com.example.guardiasmedicas.databinding.MedicoItemBinding;
import com.example.guardiasmedicas.databinding.SupervisorEditMedicoBinding;
import com.example.guardiasmedicas.domain.MedicoController;
import com.example.guardiasmedicas.ui.viewModel.Supervisor_Medicos;

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
        holder.bind(item,context,position);
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

        public void bind(Medico medico, Context context,int position){
            binding.etNombre.setText(medico.getNombres()+" "+medico.getApellidos());
            binding.etEspecialidad.setText(medico.getEspecializacion());
            binding.etCorreoE.setText(medico.getEmail());

            binding.menuMedico.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PopupMenu popup = new PopupMenu(context, view);
                    MenuInflater inflater = popup.getMenuInflater();
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            MedicoController medicoController=new MedicoController(context);
                            switch (menuItem.getItemId()) {
                                case R.id.editar:
                                    medicoController.edit(medico.getId());
                                    return true;
                                case R.id.eliminar:
                                    medicoController.deleteFromDB(medico.getId());
                                    binding.getRoot().setVisibility(View.GONE);
                                    return true;
                                default:
                                    return false;
                            }
                        }
                    });
                    inflater.inflate(R.menu.supervisor_medicoscrud_options, popup.getMenu());
                    popup.show();
                }
            });

        }





    }
}