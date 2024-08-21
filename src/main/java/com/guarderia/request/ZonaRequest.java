package com.guarderia.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
public class ZonaRequest implements Serializable {

    private Long id;
    private String letra;
    private int capacidad;

    @JsonProperty("cantidad_vehiculos")
    private int cantidadVehiculos;

    @JsonProperty("tipo_vehiculo_admitidos")
    private Long[] tipoVehiculoAdmitidos;

}
