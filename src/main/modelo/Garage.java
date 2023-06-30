package main.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Garage implements Serializable {

    private final int numero; //Identificador local del Garage
    private int contadorLuz;
    private boolean mantenimientoContratado;
    private Date fechaCompra;

    private List<TipoVehiculo> vehiculosAdminitidos;

    private Socio socio;
    private Vehiculo vehiculoGuardado;
    private Zona zona;


    public Garage(int numero, Zona zona) {
        this.numero = numero;
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
    public boolean dimensionesAptas(){
        //TODO:
        return false;
    }

    public int leerContadorLuz(){
        return this.contadorLuz;
    }

    public void contratarMantenimiento(){
        this.mantenimientoContratado = Boolean.TRUE;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isMantenimientoContratado() {
        return mantenimientoContratado;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public List<TipoVehiculo> getVehiculosAdminitidos() {
        return vehiculosAdminitidos;
    }

    public boolean estaLibre(){
        return vehiculoGuardado==null;
    }

    public void guardarVehiculo(Vehiculo v){
        //TODO: Validar vehiculo es del cliente
        vehiculoGuardado = v ;

    }

    //liberar garage (remover vehiculo)

}
