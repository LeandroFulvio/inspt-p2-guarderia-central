package main.modelo;


import main.ConsoleText;
import main.EntradaSalida;

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
        //TODO: Try catch para valir inesperado como un string

        EntradaSalida.mostrarString(ConsoleText.ADM_MENU_PRINCIPAL);
        //Leer opciones y redirigir
        switch (EntradaSalida.leerEntero()) {
            case 1: // 1.- Registrar Socio
                registrarSocio();
                break;
            case 2: //2.- Registrar Empleado
                break;
            case 3: //3.- Registrar Zona
                break;
            case 4: //4.- Registrar Garage
                break;
            case 5: //5.- Vender Garage a Socio
                break;
            case 6: //6.- Asignar Vehiculo a Garage
                break;
            case 7: //7.- Realizar Consulta
                break;
            case 0: // Salir ?
                break;
        }



    }

    private void registrarSocio(){
        //datos socio
        Socio newSocio = generarSocio();

        //Opcional crear vehiculos
        registrarVehiculos(newSocio);

        Guarderia.getIntance().registrarUsuario(newSocio);
    }

    private Socio generarSocio(){
        EntradaSalida.mostrarString(ConsoleText.CREACION_NOMBRE);
        String nombre = EntradaSalida.leerString();
        EntradaSalida.mostrarString(ConsoleText.CREACION_PASSWORD);
        String password = EntradaSalida.leerString();
        EntradaSalida.mostrarString(ConsoleText.CREACION_DIRECCION);
        String direccion = EntradaSalida.leerString();
        EntradaSalida.mostrarString(ConsoleText.CREACION_TELEFONO);
        String telefono = EntradaSalida.leerString();

        return new Socio(nombre,password,direccion,telefono);
    }

    private Empleado generarEmpleado(){
        EntradaSalida.mostrarString(ConsoleText.CREACION_NOMBRE);
        String nombre = EntradaSalida.leerString();
        EntradaSalida.mostrarString(ConsoleText.CREACION_PASSWORD);
        String password = EntradaSalida.leerString();
        EntradaSalida.mostrarString(ConsoleText.CREACION_DIRECCION);
        String direccion = EntradaSalida.leerString();
        EntradaSalida.mostrarString(ConsoleText.CREACION_TELEFONO);
        String telefono = EntradaSalida.leerString();
        EntradaSalida.mostrarString(ConsoleText.CREACION_CODIGO);
        String codigo = EntradaSalida.leerString();
        EntradaSalida.mostrarString(ConsoleText.CREACION_ESPECIALIDAD);
        String especialidad = EntradaSalida.leerString();

        return new Empleado(nombre,password,direccion,telefono,codigo,especialidad);
    }

    private void registrarVehiculos(Socio socio){
        //Opcional de deseo de generacion de vehiculo con while
        //TODO: Try catch para valir inesperado como un string

        EntradaSalida.mostrarString(ConsoleText.MENU_CREACION_VEHICULO);
        while (EntradaSalida.leerEntero()==1){
            // 1.- Agregar Vehiculo
            socio.agregarVehiculo(crearVehiculo());
            EntradaSalida.mostrarString(ConsoleText.MENU_CREACION_VEHICULO);
        }

    }

    private Vehiculo crearVehiculo(){
        /*
        Ingrese Matricula
        Ingrese nombre del vehiculo
        Elija el tipo -> Enum

         */
        EntradaSalida.mostrarString(ConsoleText.VEHICULO_REGISTRADO);
        return new Vehiculo("abc", "Modelo X", TipoVehiculo.MOTORHOME, new Dimensiones(3,3,1));
    }



}
