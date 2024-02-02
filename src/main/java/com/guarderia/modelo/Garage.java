package com.guarderia.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "garage")
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private int numero; //Identificador local del Garage

    @Column(name = "contador_luz")
    private int contadorLuz;

    @Column(name = "mantenimiento_contratado")
    private boolean mantenimientoContratado;

    @Column(name = "fecha_compra")
    private Date fechaCompra;

    //TODO: JOIN
    private List<TipoVehiculo> vehiculosAdminitidos;

    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;

    @OneToOne
    @JoinColumn(name = "vehiculo_guardado_id")
    private Vehiculo vehiculoGuardado;

    @ManyToOne
    @JoinColumn(name = "zona_id")
    private Zona zona;


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

    public boolean isVacio(){
        return vehiculoGuardado==null;
    }

    /**
     * Devuelve true cuando no tiene Socio asignado
     */
    public boolean isComprable(){
        return socio==null;
    }

//    public boolean isOwner(Socio socio){
//        return this.socio.getNombre().equals(socio.getNombre());
//    }

    public void guardarVehiculo(Vehiculo v){
        vehiculoGuardado = v ;
    }

    public void conTipoAdminitido(TipoVehiculo tipo){
        this.vehiculosAdminitidos.add(tipo);
    }

    //liberar garage (remover vehiculo)

    public boolean perteneceAZona(String letra){
        return letra.equals(zona.getLetra());
    }

//    public void mostrar(){
//        EntradaSalida.mostrarString("Garage:{");
//        EntradaSalida.mostrarString("Numero: " +numero+ ", Zona: " + zona.getLetra() + ", fecha de Compra: " + fechaCompra );
//        String datos = ", Con mantenimiento contratado: " + (mantenimientoContratado?"Si":"No") + (socio!=null ? (", Dueño: " + socio.getNombre()) : ", Sin Dueño")
//                + ", Contador de luz: " + contadorLuz + (vehiculoGuardado!=null ? (", Con Vehiculo: " + vehiculoGuardado.getNombre()) : ", Sin vehiculo Guardado");
//        EntradaSalida.mostrarString(datos);
//        EntradaSalida.mostrarString("}");
//    }
//
//    public void mostrarNombreZona(){
//        EntradaSalida.mostrarString("ID: " + numero + " Zona: " + zona.getLetra() );
//    }

}
