package com.example.registro_de_usuario;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import com.example.registro_de_usuario.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private EditText editnombre, editapellido, editemail, editpassw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        editnombre = binding.editNombre;
        editapellido = binding.editApellido;
        editemail = binding.editEmail;
        editpassw = binding.editPassw;
        Log.d("prueba1", ""+ editnombre+""+editapellido+""+editemail);
    }

    public void ingresar(View view) {
        /*if (editnombre.getText().toString().isEmpty() || editapellido.getText().toString().isEmpty()
            || editemail.getText().toString().isEmpty() || editpassw.getText().toString().isEmpty())
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Campos vacíos");
            builder.setMessage("Debe completar todos los campos.");
            builder.setPositiveButton("Aceptar", null);
            AlertDialog dialog = builder.create();
            dialog.show();
            return;
        }*/
        if (editnombre.getText().toString().isEmpty() || !editnombre.getText().toString().matches("[a-zA-Z]+")) {
            mostrarAlerta("Ingrese un Nombre válido", editnombre.getContext());
            return;
        }
        if (editapellido.getText().toString().isEmpty() || !editapellido.getText().toString().matches("[a-zA-Z]+")) {
            mostrarAlerta("Ingrese un Apellido válido", editnombre.getContext());
            return;
        }
        if (editemail.getText().toString().isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(editemail.getText().toString()).matches()) {
            mostrarAlerta("Ingrese dirección Email válida", editnombre.getContext());
            return;
        }
        if (editpassw.getText().toString().isEmpty() || editpassw.getText().toString().length() !=8) {
            mostrarAlerta("Contraseña debe contener 8 caracteres", editpassw.getContext());
            return;
        }

        Intent intento = new Intent(this, TwoActivities.class);
        intento.putExtra("nombre", editnombre.getText().toString());
        intento.putExtra("apellido", editapellido.getText().toString());
        intento.putExtra("email", editemail.getText().toString());
        intento.putExtra("password", editpassw.getText().toString());
        startActivity(intento);
    }
    public void mostrarAlerta(String titulo, Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(titulo)
                .setPositiveButton("Aceptar", null)
                .show();
    }
}