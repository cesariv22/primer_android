package com.example.registro_de_usuario;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.registro_de_usuario.databinding.ActivityTwoActivitiesBinding;


public class TwoActivities extends AppCompatActivity {
    private ActivityTwoActivitiesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTwoActivitiesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();

        String nombre = intent.getStringExtra("nombre");
        String apellido = intent.getStringExtra("apellido");
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");

        binding.getNombre.setText(nombre);
        binding.getApellido.setText(apellido);
        binding.getEmail.setText(email);
        binding.getPassword.setText(password);
        Log.d("prueba1", ""+ nombre+""+apellido+""+email);
    }
    public void volver(View view) {
            Intent intento2 = new Intent(this, MainActivity.class);
            startActivity(intento2);
        }
}