import Modelo.*;

import java.util.ArrayList;
import java.util.List;

/**
 *   FACADE ** Se usa para instanciar el resto de los elementos del sistema
 *   SINGLETON ** Solo puede existir 1 guarderia
 */
public class Guarderia {

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

    public void venderGarage(Garage garage, Socio socio){
        garage.comprar(socio);
    }




}
