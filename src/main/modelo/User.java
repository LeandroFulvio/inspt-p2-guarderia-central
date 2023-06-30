package main.modelo;

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

    public abstract void ingresar(); // Abstracto con implementacion en cada user
    public abstract void mostrarMenuPrincipal();

    public boolean validar(String pass){
        return this.password.equals(pass);
    }

    //Actualizar password con verificacion de password anterior
    public void actualizarPassword(String oldPass, String newPass){
        //TODO: Implementacion

    }

    public String getNombre() {
        return nombre;
    }

}
