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
//                EntradaSalida.leerString();
                registrarSocio();
                mostrarMenuPrincipal();
                break;
            case 2: //2.- Registrar Empleado
//                EntradaSalida.leerString();
                registrarEmpleado();
                mostrarMenuPrincipal();
                break;
            case 3: //3.- Registrar Zona
                registrarZona();
                mostrarMenuPrincipal();
                break;
            case 4: //4.- Registrar Garage
                registrarGarage();
                mostrarMenuPrincipal();
                break;
            case 5: //5.- Vender Garage a Socio

                mostrarMenuPrincipal();
                break;
            case 6: //6.- Asignar Vehiculo a Garage

                mostrarMenuPrincipal();
                break;
            case 7: //7.- Realizar Consulta
                Guarderia.getIntance().mostrarTodo();
                mostrarMenuPrincipal();
                break;
            case 0: // Salir ?
                break;
            default:
                //No valido
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

    private void registrarEmpleado(){
        Empleado newEmpleado = generarEmpleado();
        Guarderia.getIntance().registrarUsuario(newEmpleado);
    }

    private void registrarGarage(){
        Garage newGarage = generarGarage();
        Guarderia.getIntance().registrarGarage(newGarage);
    }

    private Zona obtenerZona(String letra){
        Zona zona = Guarderia.getIntance().getZonaByLetra(letra);
        if(zona!=null){
            return zona;
        }else {
            EntradaSalida.mostrarString(ConsoleText.CREACION_GARAGE_ZONA_NO_EXISTE);
            obtenerZona(EntradaSalida.leerString());
        }
        return null;
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
        while (EntradaSalida.leerEntero()==1){ // 1.- Agregar Vehiculo
//            EntradaSalida.leerString();
            socio.agregarVehiculo(crearVehiculo());
//            EntradaSalida.leerString();
            EntradaSalida.mostrarString(ConsoleText.VEHICULO_REGISTRADO);
            EntradaSalida.mostrarString(ConsoleText.MENU_CREACION_VEHICULO);
        }

    }

    private Vehiculo crearVehiculo(){
        EntradaSalida.mostrarString(ConsoleText.CREACION_MATRICULA);
        String matricula = EntradaSalida.leerString();
        EntradaSalida.mostrarString(ConsoleText.CREACION_MODELO_NOMBRE);
        String nombre = EntradaSalida.leerString();
        EntradaSalida.mostrarString(ConsoleText.CREACION_TIPO_VEHICULO);

        menuTiposVehiculo();

        return new Vehiculo(matricula, nombre, TipoVehiculo.values()[EntradaSalida.leerEntero()]);
    }

    private void registrarZona(){
        Zona newZona = generarZona();
        Guarderia.getIntance().registrarZona(newZona);
    }

    private Zona generarZona(){
        EntradaSalida.mostrarString(ConsoleText.CREACION_ZONA_LETRA);
        String letra = EntradaSalida.leerString();
        EntradaSalida.mostrarString(ConsoleText.CREACION_ZONA_CAPACIDAD);
        int capacidad = EntradaSalida.leerEntero();

        Zona zona = new Zona(letra, capacidad);

        EntradaSalida.mostrarString(ConsoleText.CREACION_ZONA_TIPO_VEHICULO_ADMITIDO);
        do {
            menuTiposVehiculo();
            zona.conTipoVehiculo(TipoVehiculo.values()[EntradaSalida.leerEntero()]);

            EntradaSalida.mostrarString(ConsoleText.CREACION_ZONA_MENU_TIPO_VEHICULO);
        }while (EntradaSalida.leerEntero()!=2);

        return zona;
    }

    private Garage generarGarage(){
        //datos garage -> Numero
        EntradaSalida.mostrarString(ConsoleText.CREACION_GARAGE_NUMERO);//Ingrese numero
        int numero = EntradaSalida.leerEntero();
        EntradaSalida.mostrarString(ConsoleText.CREACION_GARAGE_ZONA);//Ingrese Zona letra
        Garage newGarage = new Garage(numero, obtenerZona(EntradaSalida.leerString()));

        //elegir tipos adminitidos
        EntradaSalida.mostrarString(ConsoleText.CREACION_GARAGE_MENU_TIPO_ADMITIDO);
        do{
            menuTiposVehiculo();
            newGarage.conTipoAdminitido(TipoVehiculo.values()[EntradaSalida.leerEntero()]);
            EntradaSalida.mostrarString(ConsoleText.CREACION_GARAGE_MENU_AGREGAR_TIPO_ADMITIDO);
        }while (EntradaSalida.leerEntero()!=2);
        return newGarage;
    }

    private void menuTiposVehiculo(){
        for (int i=0; i < TipoVehiculo.values().length; i++) {
            EntradaSalida.mostrarString(i + ".- " + TipoVehiculo.values()[i].name());
        }
    }

}
