package Modelo;

import java.io.Serializable;

public class Zona implements Serializable {

    private String letra; //Identificador local de la Zona

    private int capacidad;
    private int cantidadVehiculos;

    //Asignacion de Empleados?

    public Zona(String letra, int capacidad, int cantidadVehiculos) {
        this.letra = letra;
        this.capacidad = capacidad;
        this.cantidadVehiculos = cantidadVehiculos;
    }

    //Registrar vehiculo en capacidad

    //Quitar vehiculo de capacidad


}
