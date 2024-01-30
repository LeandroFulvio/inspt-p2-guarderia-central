package com.guarderia.modelo;

import main.ConsoleText;
import main.EntradaSalida;

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
    /**
     * Devuelve true si el password es actualizado correctamente
     * Devuelve false si el password anterior ingresado es incorrecto
    */
    public boolean actualizarPassword(String oldPass, String newPass){
        if(this.password.equals(oldPass)) this.password = newPass;
        else return false;
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrar(){
        EntradaSalida.mostrarString("nombre:'" + nombre + '\'' +
//                ", password:'" + password + '\'' +
                ", direccion:'" + direccion + '\'' +
                ", telefono:'" + telefono + '\'' );
    }

}
