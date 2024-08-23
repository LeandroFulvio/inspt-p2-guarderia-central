package com.guarderia.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AsignacionZonaRequest {

    private Long id;
    @JsonProperty("empleado_id")
    private Long empleadoId;
    @JsonProperty("zona_id")
    private Long zonaId;
    @JsonProperty("vehiculos_asignados")
    private int vehiculosAsignados;

}
