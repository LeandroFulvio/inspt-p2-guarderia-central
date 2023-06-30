package main.modelo;


import java.io.Serializable;

public class Administrador extends User implements Serializable {


    public Administrador(String nombre, String password, String direccion, String telefono) {
        super(nombre, password, direccion, telefono);
    }

    @Override
    public void ingresar() {
        System.out.println("Soy el admin");
        mostrarMenuPrincipal();

    }

    @Override
    public void mostrarMenuPrincipal() {
        //Mostrar Menu
        /*
        1.- Registrar Socio
        2.- Registrar Empleado
        3.- Registrar Zona
        4.- Registrar Garage
        5.- Vender Garage a Socio
        6.- Asignar Vehiculo a Garage
        7.- Realizar Consulta

        Ingrese el numero de la opcion que desea
         */


        //Leer opciones y redirigir


    }


}
