package com.olmo.listaanimales;

import java.io.Serializable;

public class Animal implements Serializable {

    private int img;
    private String nombre;
    private String descripcion;

    public Animal(int imagen, String nombreAnimal, String descripcionAnimal) {
        this.img = imagen;
        this.nombre = nombreAnimal;
        this.descripcion = descripcionAnimal;
    }

    public int getImg() {
        return img;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
