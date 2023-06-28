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

    public void run(){
        //Loggear usuario


        //Usuario proceder -> Va a la imple del usuario correspondiente
    }

    //Para serializacion con archivos
    public void inicializarDatosGuarderia(Guarderia guarderia){
        instance = guarderia;
    }

    public void venderGarage(Garage garage, Socio socio){
        garage.comprar(socio);
    }

    //Obtener garages libres

    //obtener garages de un socio

    //validar vehiculo no guardado en garage




}
