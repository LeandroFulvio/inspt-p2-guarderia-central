package main.modelo;

import main.ConsoleText;
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
        mostrarMenuPrincipal();
    }

    @Override
    public void mostrarMenuPrincipal() {
        EntradaSalida.mostrarString(ConsoleText.SOCIO_MENU_PRINCIPAL);
        switch (EntradaSalida.leerEntero()) {
            case 1: //1.- Mostrar data propia
                this.mostrar();
                mostrarMenuPrincipal();
                break;
            case 2: //2.- Mostrar Vehiculos
                vehiculoList.forEach(Vehiculo::mostrar);
                mostrarMenuPrincipal();
                break;
            case 3: //3.- mostrar Garages
                Guarderia.getIntance().getGaragesBySocio(this)
                        .forEach(Garage::mostrar);
                mostrarMenuPrincipal();
                break;
            case 4: //4.- Salir
                EntradaSalida.mostrarString("Hasta la proxima!");
                break;
            default:
                break;
        }

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
        EntradaSalida.mostrarString( "}\n Vehiculos: {" );
        vehiculoList.forEach(Vehiculo::mostrar);
        EntradaSalida.mostrarString("}, fecha Ingreso a la Guarderia=" + fechaIngreso +'}');
    }

}
