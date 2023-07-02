package main.modelo;

import main.EntradaSalida;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Socio extends User implements Serializable {

    private List<Vehiculo> vehiculoList; //Vehiculos propios del Socio

    private Date fechaIngreso; //Fecha de Ingreso a la Guarderia

    public Socio(String nombre, String password, String direccion, String telefono) {
        super(nombre,password,direccion,telefono);
        this.fechaIngreso = new Date(); //Se registra la fecha de Ingreso a la guarderia al momento de crearlo
        vehiculoList = new ArrayList<>();
    }

    @Override
    public void ingresar() {

    }

    @Override
    public void mostrarMenuPrincipal() {

    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public boolean tieneVehiculoSinGarage(){
        for (Vehiculo vehiculo : vehiculoList) {
            if (!vehiculo.tieneCochera())
                return true;
        }
        return false;
    }

    public void agregarVehiculo(Vehiculo vehiculo){
        vehiculoList.add(vehiculo);
    }

    public void mostrar() {
        EntradaSalida.mostrarString("Datos Socio: {");
        super.mostrar();
        EntradaSalida.mostrarString( ", \n vehiculos: { " );
        vehiculoList.forEach(Vehiculo::mostrar);
        EntradaSalida.mostrarString("}, fechaIngreso=" + fechaIngreso +'}');
    }
}
