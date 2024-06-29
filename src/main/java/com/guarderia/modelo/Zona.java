package com.guarderia.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "zona")
public class Zona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String letra; //Identificador local de la Zona

    private int capacidad;

    @Column(name = "cantidad_vehiculos")
    private int cantidadVehiculos;

    @ManyToMany
    @JoinTable(
            name = "tipoVehiculoZona",
            joinColumns = @JoinColumn(name = "zona_id"),
            inverseJoinColumns = @JoinColumn(name = "tipoVehiculo_id")
    )
    private List<TipoVehiculo> tipoVehiculoAdminitos;




}
