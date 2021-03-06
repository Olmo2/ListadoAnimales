package com.olmo.listaanimales;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public abstract class ListaAdaptador extends BaseAdapter {

    private ArrayList<?> animales;
    private int R_layout_IdView;
    private Context contexto;

    public ListaAdaptador(Context contexto, int R_layout_IdView, ArrayList<?> animales) {
        super();
        this.contexto = contexto;
        this.animales = animales;
        this.R_layout_IdView = R_layout_IdView;
    }

    @Override
    public View getView(int posicion, View view, ViewGroup pariente) {
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R_layout_IdView, null);
        }
        onEntrada (animales.get(posicion), view);
        return view;
    }

    @Override
    public int getCount() {
        return animales.size();
    }

    @Override
    public Object getItem(int posicion) {
        return animales.get(posicion);
    }

    @Override
    public long getItemId(int posicion) {
        return posicion;
    }

    /** Devuelve cada una de las entradas con cada una de las vistas a la que debe de ser asociada
     * @param entrada La entrada que serĂ¡ la asociada a la view. La entrada es del tipo del paquete/handler
     * @param view View particular que contendrĂ¡ los datos del paquete/handler
     */
    public abstract void onEntrada(Object entrada, View view);
}
