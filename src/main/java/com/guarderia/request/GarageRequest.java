package com.guarderia.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class GarageRequest {

    private Long id;
    private int numero;
    @JsonProperty("contador_luz")
    private int contadorLuz;
    @JsonProperty("mantenimiento")
    private boolean mantenimientoContratado;
    @JsonProperty("fecha_compra")
    private Date fechaCompra;
    @JsonProperty("socio_id")
    private Long socioId;
    @JsonProperty("vehiculo_id")
    private Long vehiculoGuardadoId;
    @JsonProperty("zona_id")
    private Long zonaId;

}
