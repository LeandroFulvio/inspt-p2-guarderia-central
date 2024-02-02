package com.guarderia.request;

import com.guarderia.modelo.TipoVehiculo;
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
    private TipoVehiculo tipoVehiculo;
    private Date fechaAsignacion;
    private Long idSocio;

}
