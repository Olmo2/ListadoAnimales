package com.olmo.listaanimales;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrada_detalle);
        ImageView imagen;
        TextView nombre, desc;
        Bundle extras = getIntent().getExtras();
        imagen =   findViewById(R.id.imageViewDetalle);
        nombre = findViewById(R.id.textViewNombreDetalle);
        desc= findViewById(R.id.textViewDetalleGrande);
        Animal animal = (Animal) extras.get("Animal");

        int i= animal.getImg();
        imagen.setImageResource(animal.getImg());

        nombre.setText(animal.getNombre());
        desc.setText(animal.getDescripcion());

    }





}