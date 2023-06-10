package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Socio extends User{

    private List<Vehiculo> vehiculos;
    private Date fechaIngreso; //Fecha de Ingreso a la Guarderia


    public Socio() {
        this.fechaIngreso = new Date(); //Se registra la fecha de Ingreso al momento de crearlo
        vehiculos = new ArrayList<>();
    }





}
