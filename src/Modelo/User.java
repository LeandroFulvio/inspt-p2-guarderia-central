package Modelo;

import java.io.Serializable;

public abstract class User implements Serializable {

    private String nombre;
    private String password;
    private String direccion;
    private String telefono;

    public User(String nombre, String password, String direccion, String telefono) {
        this.nombre = nombre;
        this.password = password;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    //    public abstract void ingresar();
    //    public abstract void salir();

    //Proceder - Ingresar - Abstracto con implementacion en cada user
    //TODO: ahi acceden a su logica cada tipo de user

    //Actualizar password con verificacion de password anterior
    public void actualizarPassword(String oldPass, String newPass){
        //TODO: Implementacion

    }

    //Mostrar Menu con opciones como metodo abstracto? Depende de imple de quien llama su menu


}
