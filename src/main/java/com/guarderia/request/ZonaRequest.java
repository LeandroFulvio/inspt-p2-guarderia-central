package com.guarderia.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class ZonaRequest implements Serializable {

    private Long id;

    @NotBlank(message = "letra es requerida")
    private String letra;
    private int capacidad;

    @JsonProperty("cantidad_vehiculos")
    private int cantidadVehiculos;

    @JsonProperty("tipo_vehiculo_admitidos")
    private Long[] tipoVehiculoAdmitidos;

}
