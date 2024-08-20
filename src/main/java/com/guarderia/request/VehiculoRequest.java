package com.guarderia.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class VehiculoRequest {

    private Long id;
    private String matricula;
    private String nombre;
    @JsonProperty("tipo_vehiculo_id")
    private Long tipoVehiculo;
    private Date fechaAsignacion;
    @JsonProperty("socio_id")
    private Long idSocio;

}
