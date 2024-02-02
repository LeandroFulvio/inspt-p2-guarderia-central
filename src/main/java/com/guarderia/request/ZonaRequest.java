package com.guarderia.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.guarderia.modelo.TipoVehiculo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class ZonaRequest {

    private String letra;
    private int capacidad;

    @JsonProperty("cantidad_vehiculos")
    private int cantidadVehiculos;

    private Set<TipoVehiculo> tipoVehiculoSet;

}
