package com.example.registro_de_usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private EditText editnombre, editapellido, editemail, editpassw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editnombre = findViewById(R.id.edit_nombre);
        editapellido = findViewById(R.id.edit_apellido);
        editemail = findViewById(R.id.edit_email);
        editpassw = findViewById(R.id.edit_passw);
    }

    public void ingresar(View view) {
        if (editnombre.getText().toString().isEmpty() || editapellido.getText().toString().isEmpty() || editemail.getText().toString().isEmpty() || editpassw.getText().toString().isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Campos vacíos");
            builder.setMessage("Debe completar todos los campos.");
            builder.setPositiveButton("Aceptar", null);
            AlertDialog dialog = builder.create();
            dialog.show();
            return;
        }
        Intent intento = new Intent(this, TwoActivities.class);
        intento.putExtra("nombre", editnombre.getText().toString());
        intento.putExtra("apellido", editapellido.getText().toString());
        intento.putExtra("email", editemail.getText().toString());
        intento.putExtra("password", editpassw.getText().toString());
        startActivity(intento);
    }
}