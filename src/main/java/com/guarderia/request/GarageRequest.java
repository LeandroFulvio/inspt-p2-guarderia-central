package com.guarderia.request;

import com.guarderia.modelo.TipoVehiculo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class GarageRequest {

    private int numero;
    private int contadorLuz;
    private boolean mantenimientoContratado;
    private Date fechaCompra;
    private List<TipoVehiculo> vehiculosAdminitidos;
    private int socioId;
    private int vehiculoGuardadoId;
    private int zonaId;

}
