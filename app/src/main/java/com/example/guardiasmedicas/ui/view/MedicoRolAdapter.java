package com.example.guardiasmedicas.ui.view;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guardiasmedicas.R;
import com.example.guardiasmedicas.data.database.MySQLiteHelper;
import com.example.guardiasmedicas.data.model.Medico;
import com.example.guardiasmedicas.databinding.MedicoRolItemBinding;
import com.example.guardiasmedicas.domain.MedicoController;
import com.example.guardiasmedicas.domain.RolController;

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
            MySQLiteHelper sqlHelper=new MySQLiteHelper(context);
            SQLiteDatabase db=sqlHelper.getReadableDatabase();

            if(db!=null){
                Cursor cursor=db.rawQuery(
                        "SELECT r.nombres as rol FROM medicos as m "+
                                "INNER JOIN users as u ON u.medicoID=m.userID " +
                                "INNER JOIN roles as r ON u.rolID=r._id " +
                                "WHERE m._id="+medico.getId()+" LIMIT 1;",
                        null
                );
                if(cursor.getCount()>0) {
                    cursor.moveToFirst();
                    binding.etRolesUsuario.setText(
                            cursor.getString(cursor.getColumnIndexOrThrow("rol"))
                    );
                }
            }
            binding.tvNombresMedico.setText(medico.getNombres()+" "+medico.getApellidos());

            binding.imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PopupMenu popup=new PopupMenu(context,view);
                    MenuInflater inflater=popup.getMenuInflater();

                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            RolController rolControl=new RolController(context);
                            switch (item.getItemId()) {
                                case R.id.administrador:
                                    rolControl.asignarRol(medico.getUserID(),1);
                                    return true;
                                case R.id.supervisor:
                                    rolControl.asignarRol(medico.getUserID(),2);
                                    return true;
                                case R.id.planificador:
                                    rolControl.asignarRol(medico.getUserID(),3);
                                    return true;
                                case R.id.eliminar:
                                    rolControl.asignarRol(medico.getUserID(),4);
                                    return true;
                                default:
                                    return false;
                            }
                        }
                    });
                    inflater.inflate(R.menu.menu_admroles, popup.getMenu());
                    popup.show();


                }
            });


        }


    }
}
