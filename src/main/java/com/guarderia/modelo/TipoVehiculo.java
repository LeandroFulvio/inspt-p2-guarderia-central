package com.guarderia.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipoVehiculo")
public class TipoVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private int largo;
    private int ancho;
    private int alto;

//    @ManyToMany(mappedBy = "tipoVehiculoAdminitos", fetch = FetchType.LAZY)
//    private Set<Zona> zonas;

//    MOTORHOME(1000,200 ,270),
//    CASARODANTE(800,200 ,250),
//    ARRASTRE(600,180 ,150),
//    CARAVANA(800,200 ,220),
//    TRAILER(400,180 ,160);
//
//    //MEDIDAS EN cm
//    public final int largo;
//    public final int ancho;
//    public final int alto;
//
//    TipoVehiculo(int largo, int ancho, int alto){
//        this.largo=largo;
//        this.ancho=ancho;
//        this.alto=alto;
//    }

}
