package com.guarderia.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String letra; //Identificador local de la Zona

    private int capacidad;

    @Column(name = "cantidad_vehiculos")
    private int cantidadVehiculos;

    private List<TipoVehiculo> tipoVehiculoSet;
    //TODO: Nueva tabla para relacion zona - TipoVehiculoAdmitidos



}
