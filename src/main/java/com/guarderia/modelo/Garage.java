package com.guarderia.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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

    @JoinColumn(name = "numero", nullable = false)
    private int numero; //Identificador local del Garage

    @Column(name = "contador_luz")
    private int contadorLuz;

    @Column(name = "mantenimiento_contratado")
    private boolean mantenimientoContratado;

    @Column(name = "fecha_compra")
    private Date fechaCompra;

    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;

    @OneToOne
    @JoinColumn(name = "vehiculo_guardado_id")
    private Vehiculo vehiculoGuardado;

    @ManyToOne
    @JoinColumn(name = "zona_id", nullable = false)
    private Zona zona;

    public boolean isVacio(){
        return vehiculoGuardado==null;
    }

    /**
     * Devuelve true cuando no tiene Socio asignado
     */
    public boolean isComprable(){
        return socio==null;
    }

    public void guardarVehiculo(Vehiculo v){
        vehiculoGuardado = v ;
    }

    public boolean perteneceAZona(String letra){
        return letra.equals(zona.getLetra());
    }

}
