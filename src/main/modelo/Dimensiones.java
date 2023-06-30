package main.modelo;

import java.io.Serializable;

public class Dimensiones implements Serializable {

    private int alto;
    private int largo;
    private int ancho;


    public Dimensiones(int alto, int largo, int ancho) {
        this.alto = alto;
        this.largo = largo;
        this.ancho = ancho;
    }



}
