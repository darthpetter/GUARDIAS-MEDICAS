package com.example.guardiasmedicas.ui.viewModel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guardiasmedicas.R;
import com.example.guardiasmedicas.data.model.User;
import com.example.guardiasmedicas.data.util.RadomCodeGenerator;
import com.example.guardiasmedicas.databinding.ActivityRegistroBinding;
import com.example.guardiasmedicas.databinding.ActivitySupervisorBinding;
import com.example.guardiasmedicas.domain.RegisterController;

public class Registro extends AppCompatActivity {

    private ActivityRegistroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityRegistroBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
    }

    public void registrar(View v){
        if(!campos()){
            RadomCodeGenerator random=new RadomCodeGenerator("users",this);

            User user=new User(
                    random.generate(),
                    binding.etEmail.getText().toString(),
                    binding.etPassword.getText().toString(),
                    4
            );

            RegisterController.registerUser(user,this);

            finish();
        }else
            Toast.makeText(this, "Por favor, llena todos los campos.\uD83E\uDD7A", Toast.LENGTH_SHORT).show();
    }


    public boolean campos(){
        return binding.etEmail.getText().toString().isEmpty() &&
        binding.etPassword.getText().toString().isEmpty();
    }
}