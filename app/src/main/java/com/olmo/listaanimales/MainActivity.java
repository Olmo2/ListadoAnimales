package com.olmo.listaanimales;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listaAnimales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado);

        ArrayList<Animal> datos = new ArrayList<Animal>();

        datos.add(new Animal(R.drawable.img_buho, getString(R.string.nombre_buho), getString(R.string.descripcion_buho)));
        datos.add(new Animal(R.drawable.img_colibri, getString(R.string.nombre_colibri), getString(R.string.descripcion_colibri)));
        datos.add(new Animal(R.drawable.img_cuervo, getString(R.string.nombre_cuervo), getString(R.string.descripcion_cuervo)));
        datos.add(new Animal(R.drawable.img_flamenco, getString(R.string.nombre_flamenco), getString(R.string.descripcion_flamenco)));
        datos.add(new Animal(R.drawable.img_kiwi, getString(R.string.nombre_kiwi), getString(R.string.descripcion_kiwi)));
        datos.add(new Animal(R.drawable.img_loro, getString(R.string.nombre_loro), getString(R.string.descripcion_loro)));
        datos.add(new Animal(R.drawable.img_pavo, getString(R.string.nombre_pavo), getString(R.string.descripcion_pavo)));
        datos.add(new Animal(R.drawable.img_pinguino, getString(R.string.nombre_pingüino), getString(R.string.descripcion_pingüino)));

        listaAnimales = (ListView) findViewById(R.id.ListView_listado);
        listaAnimales.setAdapter(new ListaAdaptador(this, R.layout.entrada, datos){
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    TextView texto_superior_entrada = (TextView) view.findViewById(R.id.tvNombre);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((Animal) entrada).getNombre());


                }
            }
        });

        listaAnimales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Animal elegido = (Animal) pariente.getItemAtPosition(posicion);

                CharSequence texto = elegido.getNombre()+": "+ elegido.getDescripcion();
              /*  Toast toast = Toast.makeText(com.olmo.listaanimales.MainActivity.this, texto, Toast.LENGTH_LONG);
                toast.show();*/
                Intent intent = new Intent(MainActivity.this, AnimalInfo.class);
                intent.putExtra("Animal", (Serializable) elegido);
                startActivity(intent);
            }
        });

/*        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                ListaEntrada elegido = (ListaEntrada) pariente.getItemAtPosition(posicion);

                CharSequence texto = elegido.get_textoEncima()+": "+ elegido.get_textoDebajo();
                Toast toast = Toast.makeText(MainActivity.this, texto, Toast.LENGTH_LONG);
                toast.show();
            }
        });*/


    }
}
