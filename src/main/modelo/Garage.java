package main.modelo;

import main.EntradaSalida;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Garage implements Serializable {

    private final int numero; //Identificador local del Garage
    private int contadorLuz;
    private boolean mantenimientoContratado;
    private Date fechaCompra;

    private List<TipoVehiculo> vehiculosAdminitidos;

    private Socio socio;
    private Vehiculo vehiculoGuardado;
    private Zona zona;


    public Garage(int numero, Zona zona) {
        this.numero = numero;
        vehiculosAdminitidos = new ArrayList<>();
        this.zona = zona;
    }


    public void comprar(Socio s){
        this.socio = s;
        this.fechaCompra = new Date();
    }

    public int leerContadorLuz(){
        return this.contadorLuz;
    }

    public void contratarMantenimiento(){
        this.mantenimientoContratado = Boolean.TRUE;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isMantenimientoContratado() {
        return mantenimientoContratado;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public List<TipoVehiculo> getVehiculosAdminitidos() {
        return vehiculosAdminitidos;
    }

    public boolean isVacio(){
        return vehiculoGuardado==null;
    }

    /**
     * Devuelve true cuando no tiene Socio asignado
     */
    public boolean isComprable(){
        return socio==null;
    }

    public boolean isOwner(Socio socio){
        return this.socio.getNombre().equals(socio.getNombre());
    }

    public void guardarVehiculo(Vehiculo v){
        vehiculoGuardado = v ;
    }

    public void conTipoAdminitido(TipoVehiculo tipo){
        this.vehiculosAdminitidos.add(tipo);
    }

    //liberar garage (remover vehiculo)


    public void mostrar(){
        EntradaSalida.mostrarString("Garage:{");
        EntradaSalida.mostrarString("Numero: " +numero+ ", Zona: " + zona.getLetra() + ", fecha de Compra: " + fechaCompra );
        String datos = ", Con mantenimiento contratado: " + (mantenimientoContratado?"Si":"No") + (socio!=null ? (", Dueño: " + socio.getNombre()) : ", Sin Dueño")
                + ", Contador de luz: " + contadorLuz + (vehiculoGuardado!=null ? (", Con Vehiculo: " + vehiculoGuardado.getNombre()) : ", Sin vehiculo Guardado");
        EntradaSalida.mostrarString(datos);
        EntradaSalida.mostrarString("}");
    }

    public void mostrarNombreZona(){
        EntradaSalida.mostrarString("ID: " + numero + " Zona: " + zona.getLetra() );
    }

}
