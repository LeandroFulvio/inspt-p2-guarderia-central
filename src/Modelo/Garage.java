package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Garage {

    private int numero; //Identificador local del Garage
    private int contadorLuz;
    private boolean mantenimientoContratado;
    private Date fechaCompra;

    private List<TipoVehiculo> vehiculosAdminitidos;
    private Dimensiones dimensionGarage;

    private Socio socio;
    private Zona zona;


    public Garage(int numero, Dimensiones dimensiones, Zona zona) {
        this.numero = numero;
        this.dimensionGarage = dimensiones;
        vehiculosAdminitidos = new ArrayList<>();
        this.zona = zona;
    }


    public void comprar(Socio s){
        this.socio = s;
        this.fechaCompra = new Date();
    }

    /**
     * Compara las dimensiones del vehiculo con las propias
     */
    public boolean dimensionesAptas(Dimensiones dimensionVehiculo){
        //TODO:
        return false;
    }

    public int leerContadorLuz(){
        return this.contadorLuz;
    }

    public void contratarMantenimiento(){
        this.mantenimientoContratado = Boolean.TRUE;
    }


}
