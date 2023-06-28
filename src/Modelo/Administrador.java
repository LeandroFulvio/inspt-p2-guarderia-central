package Modelo;

import java.io.Serializable;

public class Administrador extends User implements Serializable {


    public Administrador(String nombre, String password, String direccion, String telefono) {
        super(nombre, password, direccion, telefono);
    }


}
