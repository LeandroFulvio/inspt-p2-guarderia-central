package com.guarderia.modelo;

import main.ConsoleText;
import main.EntradaSalida;
import main.FileManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *   FACADE ** Se usa para instanciar el resto de los elementos del sistema
 *   SINGLETON ** Solo puede existir 1 guarderia
 */
public class Guarderia implements Serializable {

    private static Guarderia instance = null;

    private Guarderia(){
        garageList = new ArrayList<>();
        zonaList = new ArrayList<>();
        usuarioList = new ArrayList<>();

        socioList = new ArrayList<>();
        empleadoList = new ArrayList<>();

        //Manejo de archivo - Excepciones manejadas por el FileManager
        FileManager fileManager = new FileManager();
        instance = fileManager.deserealizarGuarderia("Guarderia-central.txt");
        if(instance!=null) cargarData(instance);
    }

    private void cargarData(Guarderia oldInstance){
        this.usuarioList = oldInstance.usuarioList;
        this.garageList = oldInstance.garageList;
        this.zonaList = oldInstance.zonaList;
        this.socioList = oldInstance.socioList;
        this.empleadoList = oldInstance.empleadoList;
    }

    public static Guarderia getIntance(){
        if (instance == null){
            instance = new Guarderia();
        }
        return instance;
    }

    private List<Garage> garageList;
    private List<Zona> zonaList;
    private List<User> usuarioList;
    private User loggedUser;

    private List<Socio> socioList;
    private List<Empleado> empleadoList;

    private void save(){
        loggedUser=null;
        instance=this;
        //Serializar
        FileManager fileManager = new FileManager();
        fileManager.serializarGuaderia("Guarderia-central.txt", this);
    }

    public void run(){
        //Loggear usuario
        if (!usuarioList.isEmpty()) loggin();
        else primerLoggin();

        //Usuario proceder -> Va a la imple del usuario correspondiente
        loggedUser.ingresar();

        //Salvar datos sistema
        save();
    }


    public void venderGarage(Garage garage, Socio socio){
        garage.comprar(socio);
    }

    public void guardarVehiculoEnGarage(Garage garage, Vehiculo vehiculo){
        //TODO: updates? Necesario?
        garageList.stream()
                .filter(g->g.getNumero()== garage.getNumero())
                .peek(g -> g.guardarVehiculo(vehiculo))
                .collect(Collectors.toList());

    }

    //obtener garages de un socio

    //validar vehiculo no guardado en garage



    private void loggin(){
        EntradaSalida.mostrarString(ConsoleText.BIENVENIDA);
        //Pedir credenciales
        while(loggedUser==null){
            EntradaSalida.mostrarString(ConsoleText.CREACION_NOMBRE);
            String nombre = EntradaSalida.leerString();
            EntradaSalida.mostrarString(ConsoleText.CREACION_PASSWORD);
            String password = EntradaSalida.leerString();

            User u = getUserByName(nombre);
            //validar
            if(u!=null && u.validar(password)){
                //marcar como usuario loggeado
                loggedUser=u;
                EntradaSalida.mostrarString(ConsoleText.LOGGED_AS + nombre);
            }else {
                //bad credential
                EntradaSalida.mostrarString(ConsoleText.BAD_CREDENTIALS);
            }
        }
    }


    private void primerLoggin(){
        //Crear administrador
        EntradaSalida.mostrarString(ConsoleText.MENU_PRIMER_LOGGIN_1);
        String nombre = EntradaSalida.leerString();
        EntradaSalida.mostrarString(ConsoleText.CREACION_PASSWORD);
        String password = EntradaSalida.leerString();
        EntradaSalida.mostrarString(ConsoleText.CREACION_DIRECCION);
        String direccion = EntradaSalida.leerString();
        EntradaSalida.mostrarString(ConsoleText.CREACION_TELEFONO);
        String telefono = EntradaSalida.leerString();

        Administrador adm = new Administrador(nombre, password, direccion, telefono);
        usuarioList.add(adm);
        loggedUser = adm;
    }

    private User getUserByName(String nombre){
        return usuarioList.stream()
                .filter(x-> x.getNombre().equals(nombre))
                .findFirst().orElse(null);
    }

    public void registrarUsuario(User usuario){
        this.usuarioList.add(usuario);
    }

    public void registrarSocio(Socio s){
        this.socioList.add(s);
    }

    public void registrarEmpleado(Empleado e){
        this.empleadoList.add(e);
    }

    public void registrarZona(Zona zona){
        this.zonaList.add(zona);
    }

    public Zona getZonaByLetra(String letra){
        return this.zonaList.stream()
                .filter(x-> x.getLetra().equals(letra))
                .findFirst().orElse(null);
    }

    public void registrarGarage(Garage garage){
        this.garageList.add(garage);
    }

    public List<String> getSocioNameList(){
        return this.socioList.stream()
                .map(User::getNombre)
                .collect(Collectors.toList());
    }

    public Socio getSocioByName(String name){
        return this.socioList.stream()
                .filter(x-> (name).equals(x.getNombre()))
                .findFirst().orElse(null);
    }

    public List<Garage> getGaragesLibres(){
        return this.garageList.stream()
                .filter(Garage::isComprable)
                .collect(Collectors.toList());
    }

    public List<Garage> getGaragesByZona(Zona zona){
        return this.garageList.stream()
                .filter(g->g.perteneceAZona(zona.getLetra()))
                .collect(Collectors.toList());
    }

    public List<Socio> getSociosConVehiculoSinGuardar(){
        return this.socioList.stream()
                .filter(Socio::tieneVehiculoSinGarage)
                .collect(Collectors.toList());
    }

    public List<Garage> getGaragesBySocio(Socio socio){
        return this.garageList.stream()
                .filter(g -> g.isOwner(socio))
                .collect(Collectors.toList());
    }

    public List<Garage> getGaragesLibreBySocio(Socio socio){
        return this.garageList.stream()
                .filter(g -> g.isVacio() && g.isOwner(socio))
                .collect(Collectors.toList());
    }

    public List<Empleado> getEmpleadoList(){
        return this.empleadoList;
    }

    public List<Zona> getZonaList(){
        return this.zonaList;
    }

    public void mostrarTodo(){
        EntradaSalida.mostrarString("Guarderia { ");

        //Zonas
        EntradaSalida.mostrarString("Zonas { ");
        this.zonaList.forEach(Zona::mostrar);
        EntradaSalida.mostrarString("}");

        //Garages
        EntradaSalida.mostrarString("Garages { ");
        this.garageList.forEach(Garage::mostrar);
        EntradaSalida.mostrarString("}");

        //Empleados
        EntradaSalida.mostrarString("Empleados { ");
        this.empleadoList.forEach(Empleado::mostrar);
        EntradaSalida.mostrarString("}");

        //Socios
        EntradaSalida.mostrarString("Socios { ");
        this.socioList.forEach(Socio::mostrar);
        EntradaSalida.mostrarString(" }");

        EntradaSalida.mostrarString("}");
    }

}
