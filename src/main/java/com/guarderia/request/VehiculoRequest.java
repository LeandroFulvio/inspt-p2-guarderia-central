package com.guarderia.request;

import jakarta.persistence.JoinColumn;
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
    @JoinColumn(name = "tipo_vehiculo_id")
    private Long tipoVehiculo;
    private Date fechaAsignacion;
    private Long idSocio;

}
