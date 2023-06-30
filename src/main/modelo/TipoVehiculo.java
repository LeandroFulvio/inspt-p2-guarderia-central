package main.modelo;

import java.io.Serializable;

public enum TipoVehiculo implements Serializable {

    MOTORHOME(1000,200 ,270),
    CASARODANTE(800,200 ,250),
    ARRASTRE(600,180 ,150),
    CARAVANA(800,200 ,220),
    TRAILER(400,180 ,160);

    //MEDIDAS EN cm
    public final int largo;
    public final int ancho;
    public final int alto;

    TipoVehiculo(int largo, int ancho, int alto){
        this.largo=largo;
        this.ancho=ancho;
        this.alto=alto;
    }
}
