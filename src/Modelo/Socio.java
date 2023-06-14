package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Socio extends User{

    private List<Vehiculo> vehiculoList;

    private Date fechaIngreso; //Fecha de Ingreso a la Guarderia

    public Socio(String nombre, String password, String direccion, String telefono) {
        super(nombre,password,direccion,telefono);
        this.fechaIngreso = new Date(); //Se registra la fecha de Ingreso al momento de crearlo
        vehiculoList = new ArrayList<>();
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void agregarVehiculo(Vehiculo vehiculo){
        vehiculoList.add(vehiculo);
    }



}
