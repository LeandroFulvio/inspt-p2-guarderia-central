package Modelo;

public abstract class User {

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

}
