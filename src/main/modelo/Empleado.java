package main.modelo;

import main.EntradaSalida;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Empleado extends User implements Serializable {

    private String codigo;
    private String especialidad;

    private Set<Zona> zonasAsignadas;

    public Empleado(String nombre, String password, String direccion, String telefono, String codigo, String especialidad) {
        super(nombre, password, direccion, telefono);
        this.codigo=codigo;
        this.especialidad=especialidad;
        this.zonasAsignadas = new HashSet<>();
    }

    @Override
    public void ingresar() {
        mostrarMenuPrincipal();
    }

    @Override
    public void mostrarMenuPrincipal() {
        //Menu mostrar data propia
        //Mostrar zonas
        //mostrar garages de las zonas a cargo
        //Salir?

    }

    @Override
    public void mostrar(){
        EntradaSalida.mostrarString("Datos Empleado: {");
        super.mostrar();
        EntradaSalida.mostrarString(", codigo: " + codigo + ", especialidad: " + especialidad + ", Zonas Asignadas: {\n");
        zonasAsignadas.forEach(Zona::mostrarLetra);
        EntradaSalida.mostrarString("\n }\n}");
    }

    public void asignarZona(Zona zona){
        zonasAsignadas.add(zona);
    }

}
