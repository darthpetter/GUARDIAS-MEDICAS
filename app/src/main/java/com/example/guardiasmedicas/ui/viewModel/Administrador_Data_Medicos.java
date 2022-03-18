package com.example.guardiasmedicas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Administrador_Data_Medicos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador_data_medicos);
    }
    public void showPopUp(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this::onMenuItemClick);
        popup.inflate(R.menu.menu_admroles);
        popup.show();
    }
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.administrador:
                Toast.makeText(this, "Se cambió el rol a administrador.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.supervisor:
                Toast.makeText(this, "Se cambió el rol a supervisor.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.planificador:
                Toast.makeText(this, "Se cambió el rol a planificador.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.eliminar:
                Toast.makeText(this, "Eliminando usuario, jajaja;)", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }
}