package com.example.registro_de_usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TwoActivities extends AppCompatActivity {
    public TextView get_nombre, get_apellido, get_email, get_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_activities);

        Intent intent = getIntent();

        String nombre = intent.getStringExtra("nombre");
        String apellido = intent.getStringExtra("apellido");
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");

        get_nombre = findViewById(R.id.get_nombre);
        get_apellido = findViewById(R.id.get_apellido);
        get_email = findViewById(R.id.get_email);
        get_password = findViewById(R.id.get_password);

        get_nombre.setText(nombre);
        get_apellido.setText(apellido);
        get_email.setText(email);
        get_password.setText(password);
    }
    public void volver(View view) {
            Intent intento2 = new Intent(this, MainActivity.class);
            startActivity(intento2);
        }
}