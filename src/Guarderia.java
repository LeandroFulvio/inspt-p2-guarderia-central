import Modelo.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
        //Manejo de archivo - Excepciones manejadas por el FileManager
        FileManager fileManager = new FileManager();
        instance = fileManager.deserealizarGuarderia("Guarderia-central.txt");
        if(instance!=null) cargarData(instance);
    }

    private void cargarData(Guarderia oldInstance){
        this.usuarioList = oldInstance.usuarioList;
        this.garageList = oldInstance.garageList;
        this.zonaList = oldInstance.zonaList;
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

    private void save(){
        loggedUser=null;
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

    //Obtener garages libres

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
            if(u.validar(password)){
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

}
