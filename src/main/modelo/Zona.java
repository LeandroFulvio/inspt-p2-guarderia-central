package main.modelo;

import main.EntradaSalida;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Zona implements Serializable {

    private String letra; //Identificador local de la Zona

    private int capacidad;
    private int cantidadVehiculos;

    private Set<TipoVehiculo> tipoVehiculoSet;

    public Zona(String letra, int capacidad) {
        this.letra = letra;
        this.capacidad = capacidad;
        this.cantidadVehiculos = 0;
        this.tipoVehiculoSet = new HashSet<>();
    }

    //Registrar vehiculo en capacidad

    //Quitar vehiculo de capacidad


    public void conTipoVehiculo(TipoVehiculo tipoVehiculo){
        tipoVehiculoSet.add(tipoVehiculo);
    }

    public String getLetra() {
        return letra;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void mostrar(){
        EntradaSalida.mostrarString("Zona{" +
                " Letra:'" + letra + '\'' +
                ", Capacidad:" + capacidad +
                ", Cantidad de vehiculos:" + cantidadVehiculos +
                ", Tipo Vehiculo Admitidos { ");
        tipoVehiculoSet.forEach(tp -> EntradaSalida.mostrarString(tp.name() + " ") );
        EntradaSalida.mostrarString("}");
    }

    public void mostrarLetra(){
        EntradaSalida.mostrarString(letra + "  ");
    }

}
