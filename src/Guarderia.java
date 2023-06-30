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
        //Serializar
        FileManager fileManager = new FileManager();
        fileManager.serializarGuaderia("Guarderia-central.txt", this);
    }

    public void run(){
        //Loggear usuario
        if (usuarioList.isEmpty()) loggin();
        else primerLoggin();

        //Usuario proceder -> Va a la imple del usuario correspondiente



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
        //Pedir credenciales

        //validar

        //marcar como usuario loggeado
    }

    private void primerLoggin(){
        //Crear administrador

        //marcar como usuario loggeado
    }

}
