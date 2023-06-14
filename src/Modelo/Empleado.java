package Modelo;

public class Empleado extends User{

    private String codigo;
    private String especialidad;

    //Zonas?

    public Empleado(String nombre, String password, String direccion, String telefono, String codigo, String especialidad) {
        super(nombre, password, direccion, telefono);
        this.codigo=codigo;
        this.especialidad=especialidad;
    }



}
