package com.example.guardiasmedicas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Planificador_Registro_Guardia extends AppCompatActivity {
    private Spinner sp1;
    private EditText fechainicio, horainicio, fechafin, horafin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planificador_registro_guardia);

        sp1=findViewById(R.id.spinner);
        String Medicos[]={"Doctor Ivan Kaviedes","Doctor Juan Perez","Doctora Sufrida Pechiche"};
        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Medicos);
        sp1.setAdapter(adaptador);

        fechainicio=findViewById(R.id.etFechaInicio);
        fechafin=findViewById(R.id.etFechaFin);
        horainicio=findViewById(R.id.edtHoraInicio);
        horafin=findViewById(R.id.etHoraFin);
    }
    public void guardar(View v){
        if(verificar_campos()){
            Toast.makeText(this, "Guardia Almacenada Exitosamente!", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(this, "Por favor, llena todos los campos.\uD83E\uDD7A", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean verificar_campos(){
        if(fechainicio.getText().toString().isEmpty() && fechainicio.getText().toString().isEmpty() && horainicio.getText().toString().isEmpty() && horafin.getText().toString().isEmpty())
            return false;
        else
            return true;
    }
}