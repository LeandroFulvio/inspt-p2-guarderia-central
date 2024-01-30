package com.guarderia.modelo;


import main.ConsoleText;
import main.EntradaSalida;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        EntradaSalida.mostrarString(ConsoleText.ADM_MENU_PRINCIPAL);
        //Leer opciones y redirigir
        switch (EntradaSalida.leerEntero()) {
            case 1: // 1.- Registrar Socio
                registrarSocio();
                mostrarMenuPrincipal();
                break;
            case 2: //2.- Registrar Empleado
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
                mostrarMenuVentaGarage();
                mostrarMenuPrincipal();
                break;
            case 6: //6.- Asignar Vehiculo a Garage
                mostrarMenuAsignarVehiculoGarage();
                mostrarMenuPrincipal();
                break;
            case 7: //7.- Asignar Empleado a Zona
                mostrarMenuAsignarZonaAEmpleado();
                //TODO:
                mostrarMenuPrincipal();
                break;
            case 8: //8.- Realizar Consulta
                Guarderia.getIntance().mostrarTodo();
                mostrarMenuPrincipal();
                break;
            case 0: // Salir ?
                EntradaSalida.mostrarString("Hasta la proxima!");
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
        EntradaSalida.mostrarString("Socio creado.");
        Guarderia.getIntance().registrarUsuario(newSocio);
        Guarderia.getIntance().registrarSocio(newSocio);
    }

    private void registrarEmpleado(){
        Empleado newEmpleado = generarEmpleado();
        EntradaSalida.mostrarString("Empleado creado.");
        Guarderia.getIntance().registrarUsuario(newEmpleado);
        Guarderia.getIntance().registrarEmpleado(newEmpleado);
    }

    private void registrarGarage(){
        Garage newGarage = generarGarage();
        EntradaSalida.mostrarString("Garage creado.");
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
        EntradaSalida.mostrarString(ConsoleText.MENU_CREACION_VEHICULO);
        while (EntradaSalida.leerEntero()==1){ // 1.- Agregar Vehiculo
            socio.agregarVehiculo(crearVehiculo());
            EntradaSalida.mostrarString(ConsoleText.VEHICULO_REGISTRADO);
            EntradaSalida.mostrarString(ConsoleText.MENU_CREACION_VEHICULO);
        }
        EntradaSalida.mostrarString("Vehiculo creado.");
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
        EntradaSalida.mostrarString("Zona creada.");
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
        EntradaSalida.mostrarString(ConsoleText.CREACION_GARAGE_MENU_TIPO_ADMITIDO); //TODO: Revisar si esto lo determina la zona y listo
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

    private void menuListaDeSocios(List<String> socioNames){
        for (int i=0; i < socioNames.size(); i++) {
            EntradaSalida.mostrarString(i + ".- " + socioNames.get(i));
        }
    }

    private void menuListaDeGarages(List<Garage> garages){
        garages.forEach(Garage::mostrarNombreZona);
    }

    private void menuListaDeVehiculos(List<Vehiculo> vehiculos){
        for (int i=0; i < vehiculos.size(); i++) {
            EntradaSalida.mostrarString(i + ".- "); //Indice para elegir
            vehiculos.get(i).mostrar(); //datos del vehiculo
        }
    }

    private void mostrarMenuVentaGarage(){
        //Seleccionar Socio
        Socio socio = menuSeleccionSocio(Guarderia.getIntance().getSocioNameList());

        //Seleccionar Garage ->             obtener garages libres
        Garage garage = menuSeleccionGarage(Guarderia.getIntance().getGaragesLibres());

        //Registrar venta
        Guarderia.getIntance().venderGarage(garage, socio);
    }

    private Socio menuSeleccionSocio(List<String> socioNames){
        //Muestra lista de nombres de los socios
        EntradaSalida.mostrarString(ConsoleText.MENU_SELECCION_SOCIO);
        menuListaDeSocios(socioNames);
        String nombreSeleccionado = null;
        while (nombreSeleccionado==null) {
            try {
                nombreSeleccionado = socioNames.get(EntradaSalida.leerEntero());
            } catch (Exception e) {
                EntradaSalida.mostrarString(ConsoleText.NOMBRE_SOCIO_FUERA_RANGO);
            }
        }
        return Guarderia.getIntance().getSocioByName(nombreSeleccionado);
    }

    private Garage menuSeleccionGarage(List<Garage> garages){
        //mostrarlos
        EntradaSalida.mostrarString(ConsoleText.MENU_SELECCION_GARAGE);
        menuListaDeGarages(garages);

        //Leer ID
        Garage garage = null;
        while (garage==null){
            int seleccion = EntradaSalida.leerEntero();
            garage = garages.stream()
                    .filter(g-> g.getNumero()==seleccion)
                    .findFirst().orElse(null);
            if (garage==null) EntradaSalida.mostrarString(ConsoleText.ID_NO_EXISTE);
        }
        return garage;
    }

    private Vehiculo menuSeleccionVehiculo(List<Vehiculo> vehiculos){
        //mostrar los vehiculos
        EntradaSalida.mostrarString(ConsoleText.MENU_SELECCION_VEHICULO);
        menuListaDeVehiculos(vehiculos);

        //Leer id de la lista
        Vehiculo vehiculoSeleccionado = null;
        while (vehiculoSeleccionado==null){
            int seleccion = EntradaSalida.leerEntero();
            try {
                vehiculoSeleccionado = vehiculos.get(seleccion);
            }catch (Exception e){
                EntradaSalida.mostrarString(ConsoleText.ID_NO_EXISTE);
            }
        }
        return vehiculoSeleccionado;
    }

    private void mostrarMenuAsignarVehiculoGarage(){
        //Elegir Socio con al menos 1 Vehiculo sin Guardar
        List<Socio> sociosConVehiculoSinGuardar = Guarderia.getIntance().getSociosConVehiculoSinGuardar();
        //TODO: Si vacio, saltear?

        //Mostrar socios y que elija
        Socio socioSeleccionado = menuSeleccionSocio( sociosConVehiculoSinGuardar.stream()
                                                                .map(Socio::getNombre)
                                                                .collect(Collectors.toList()) );

        //Buscar Garages del Socio y se elije
        Garage garageSeleccionado = menuSeleccionGarage(Guarderia.getIntance().getGaragesLibreBySocio(socioSeleccionado));

        //Buscar Vehiculos del socio y Guardarlo
        List<Vehiculo> vehiculosSinCochera = socioSeleccionado.getVehiculoList()
                                                            .stream()
                                                            .filter(x->!x.tieneCochera())
                                                            .collect(Collectors.toList());
        Vehiculo vehiculoAGuardar = menuSeleccionVehiculo(vehiculosSinCochera);
        //TODO: Validacion de tipo de vehiculo

        //Updates
        vehiculoAGuardar.setFechaAsignacion(new Date());
        garageSeleccionado.guardarVehiculo(vehiculoAGuardar);

        //Guardar Vehiculo en Garage para actualizar en instancia?
        Guarderia.getIntance().guardarVehiculoEnGarage(garageSeleccionado, vehiculoAGuardar);
        //Actualizar Socio?
    }

    private void mostrarMenuAsignarZonaAEmpleado(){
        //Elegir empleado
        Empleado empleadoSeleccionado = menuSeleccionarEmpleado(Guarderia.getIntance().getEmpleadoList());

        //Elegir y Asignar Zonas
        Zona zonaSeleccionada = menuSeleccionarZona();
        EntradaSalida.mostrarString("Asignacion completa!");
        empleadoSeleccionado.asignarZona(zonaSeleccionada);
    }

    private Empleado menuSeleccionarEmpleado(List<Empleado> empleados){
        EntradaSalida.mostrarString(ConsoleText.MENU_SELECCION_EMPLEADO);
        //Menu de empleados
        empleados.forEach(Empleado::mostrarNombreCodigo);

        //Leer codigo y buscar empleado
        Empleado empleadoSeleccionado = null;
        while (empleadoSeleccionado==null){
            String codigo = EntradaSalida.leerString();

            empleadoSeleccionado = empleados.stream()
                    .filter(e-> e.isCodigo(codigo))
                    .findFirst().orElse(null);

            if (empleadoSeleccionado==null) EntradaSalida.mostrarString(ConsoleText.MENU_CODIGO_NO_EXISTE);
        }
        return empleadoSeleccionado;
    }

    private Zona menuSeleccionarZona(){
        //Mostrar Zonas
        EntradaSalida.mostrarString(ConsoleText.MENU_SELECCION_ZONA);
        Guarderia.getIntance().getZonaList().forEach(Zona::mostrar);

        //Leer Letra
        Zona zonaSeleccionada = null;
        while (zonaSeleccionada==null){
            String letra = EntradaSalida.leerString();
            zonaSeleccionada = Guarderia.getIntance().getZonaByLetra(letra);
            if(zonaSeleccionada==null) EntradaSalida.mostrarString(ConsoleText.MENU_LETRA_NO_EXISTE);
        }

        return zonaSeleccionada;
    }


}
