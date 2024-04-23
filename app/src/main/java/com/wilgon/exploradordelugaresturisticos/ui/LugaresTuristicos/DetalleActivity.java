package com.wilgon.exploradordelugaresturisticos.ui.LugaresTuristicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.wilgon.exploradordelugaresturisticos.R;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        // Recibir datos del Intent
        Intent intent = getIntent();

        String nombre = intent.getStringExtra("nombre");
        String descripcion = intent.getStringExtra("descripcion");
        int imagen = intent.getIntExtra("imagen", 0); // Aquí, 0 es un valor predeterminado en caso de que no se encuentre el valor
        int imagen2 = intent.getIntExtra("imagen2", 0);
        String horarioApertura = intent.getStringExtra("horarioApertura");

        // Mostrar datos en la actividad de detalle
        TextView nombreTextView = findViewById(R.id.nombreTextView);
        TextView descripcionTextView = findViewById(R.id.descripcionTextView);
        ImageView imagenPrincipal = findViewById(R.id.imagenPrincipal);
        TextView horarioAperturaTextView = findViewById(R.id.horarioAperturaTextView);
        ImageView imagenSecundaria = findViewById(R.id.imagenSecundaria);


        nombreTextView.setText(nombre);
        descripcionTextView.setText(descripcion);
        imagenPrincipal.setImageResource(imagen);
        imagenSecundaria.setImageResource(imagen2);
        horarioAperturaTextView.setText("Horario de Visita: " + horarioApertura);
    }






    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

    }

     */
}