package com.guarderia.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "zonas")
public class Zona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String letra; //Identificador local de la Zona
    private int capacidad;
    private int ancho;
    private int profundidad;

    @Column(name = "cantidad_vehiculos")
    private int cantidadVehiculos;

    @ManyToMany
    @JoinTable(
            name = "tipoVehiculosZonas",
            joinColumns = @JoinColumn(name = "zona_id"),
            inverseJoinColumns = @JoinColumn(name = "tipoVehiculo_id")
    )
    private List<TipoVehiculo> tipoVehiculoAdminitos;

    @OneToMany(mappedBy = "zona")
    private Set<AsignacionZona> asignacionZona;//Lazy, no va a responderse en consultas de Zona

}
