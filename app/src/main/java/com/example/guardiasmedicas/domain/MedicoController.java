package com.example.guardiasmedicas.domain;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.guardiasmedicas.data.database.MySQLiteHelper;
import com.example.guardiasmedicas.data.model.Medico;
import com.example.guardiasmedicas.data.model.User;
import com.example.guardiasmedicas.databinding.SupervisorEditMedicoBinding;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MedicoController {
    private final Context context;

    public MedicoController(Context context){
        this.context=context;
    }

    public void insertOnDB(Medico medico){
        MySQLiteHelper sqlHelper=new MySQLiteHelper(context);
        SQLiteDatabase db=sqlHelper.getWritableDatabase();

        if(db!=null){
            db.insert("medicos",null,medico.getModeloInsercion());
        }
    }

    public List<Medico> getFromDB(){
        MySQLiteHelper sqlHelper=new MySQLiteHelper(context);
        SQLiteDatabase db=sqlHelper.getReadableDatabase();
        List<Medico> medicos= new LinkedList<Medico>(Arrays.asList());;
        if(db!=null){
            Cursor cursor=db.rawQuery("SELECT * FROM medicos",
                    null
            );

            if(cursor.getCount()>0) {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    Medico medico = new Medico(
                            cursor.getString(cursor.getColumnIndexOrThrow("nombres")),
                            cursor.getString(cursor.getColumnIndexOrThrow("apellidos")),
                            cursor.getString(cursor.getColumnIndexOrThrow("especializacion")),
                            cursor.getString(cursor.getColumnIndexOrThrow("email"))
                    );
                    medico.setId(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));

                    medicos.add(medico);
                    cursor.moveToNext();
                }
            }

        }
        return medicos;
    }

    public void deleteFromDB(int codigo){
        MySQLiteHelper sqlHelper=new MySQLiteHelper(context);
        SQLiteDatabase db=sqlHelper.getWritableDatabase();

        if(db!=null){
            db.delete("medicos","_id='"+codigo+"'",null);
        }
    }

    public void edit(int codigo){
        MySQLiteHelper sqlHelper=new MySQLiteHelper(context);
        SQLiteDatabase db=sqlHelper.getWritableDatabase();

        if(db!=null){
            Cursor cursor=db.rawQuery("SELECT * FROM medicos WHERE _id='"+codigo+"'",null);
            cursor.moveToFirst();

            Dialog dialog = new Dialog(context);
            SupervisorEditMedicoBinding binding=SupervisorEditMedicoBinding.inflate(LayoutInflater.from(context));
            dialog.setContentView(binding.getRoot());

            binding.etNombreE.setText(cursor.getString(cursor.getColumnIndexOrThrow("nombres")));
            binding.etApellidoE.setText(cursor.getString(cursor.getColumnIndexOrThrow("apellidos")));
            binding.etEspecialidadE.setText(cursor.getString(cursor.getColumnIndexOrThrow("especializacion")));
            binding.etEmailE.setText(cursor.getString(cursor.getColumnIndexOrThrow("email")));


            binding.btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Medico medico=new Medico(
                        binding.etNombreE.getText().toString(),
                        binding.etApellidoE.getText().toString(),
                        binding.etEspecialidadE.getText().toString(),
                        binding.etEmailE.getText().toString()
                    );

                    medico.setId(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));

                    if(update(medico)){
                        Toast.makeText(context, "Actualizado correctamente.", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }else{
                        Toast.makeText(context, "Algo salió mal.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            binding.btnDiscard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            dialog.show();

            //TODO mandar a la vista y en el viewmodel codificar si es nulo el bundle no se llena sino si
        }

    }

    private Boolean update(Medico medico){
        MySQLiteHelper sqlHelper=new MySQLiteHelper(context);
        SQLiteDatabase db=sqlHelper.getWritableDatabase();

        if(db!=null){
            db.update(
                    "medicos",
                    medico.getModeloInsercion(),
                    "_id="+medico.getId(),
                    null
            );
            return true;
        }
        return false;
    }


}
