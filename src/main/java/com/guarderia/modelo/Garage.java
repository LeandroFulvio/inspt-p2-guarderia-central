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
@Table(name = "garages")
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero; //Identificador local del Garage

    @Column(name = "contador_luz")
    private int contadorLuz;

    @Column(name = "mantenimiento_contratado")
    private boolean mantenimientoContratado;

    @Column(name = "fecha_compra")
    private Date fechaCompra;

//    @ManyToMany()
//    @JoinTable(
//            name = "garage_tipo_vehiculo",
//            joinColumns = @JoinColumn(name = "garage_id"),
//            inverseJoinColumns = @JoinColumn(name = "tipo_vehiculo_id")
//    )
//    private List<TipoVehiculo> vehiculosAdmitidos;

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

//    public void conTipoAdminitido(TipoVehiculo tipo){
//        this.vehiculosAdmitidos.add(tipo);
//    }

    //liberar garage (remover vehiculo)

    public boolean perteneceAZona(String letra){
        return letra.equals(zona.getLetra());
    }

}
