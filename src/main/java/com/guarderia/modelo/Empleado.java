package com.guarderia.modelo;

import main.ConsoleText;
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
        EntradaSalida.mostrarString(ConsoleText.EMPLEADO_MENU_PRINCIPAL);
        switch (EntradaSalida.leerEntero()) {
            case 1: //1.- Menu mostrar data propia
                this.mostrar();
                mostrarMenuPrincipal();
                break;
            case 2: //2.- Mostrar zonas
                this.zonasAsignadas.forEach(Zona::mostrar);
                mostrarMenuPrincipal();
                break;
            case 3: //3.- mostrar garages de las zonas a cargo
                zonasAsignadas.forEach(x->{
                    Guarderia.getIntance().getGaragesByZona(x)
                            .forEach(Garage::mostrar);
                });
                mostrarMenuPrincipal();
                break;
            case 4: //4.- Salir
                EntradaSalida.mostrarString("Hasta la proxima!");
                break;
            default:
                break;
        }
    }

    @Override
    public void mostrar(){
        EntradaSalida.mostrarString("Datos Empleado: {");
        super.mostrar();
        EntradaSalida.mostrarString(", codigo: " + codigo + ", especialidad: " + especialidad + ", Zonas Asignadas: {\n");
        zonasAsignadas.forEach(Zona::mostrarLetra);
        EntradaSalida.mostrarString("\n }\n}");
    }

    public void mostrarNombreCodigo(){
        EntradaSalida.mostrarString("Codigo: " + codigo + " Nombre: " + getNombre() );
    }

    public void asignarZona(Zona zona){
        zonasAsignadas.add(zona);
    }

    public boolean isCodigo(String codigo){
        return codigo.equals(this.codigo);
    }

}
