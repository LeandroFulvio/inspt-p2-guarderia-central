package com.guarderia.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AsignacionZonaRequest {

    private Long id;
    @JsonProperty("empleado_id")
    @NotBlank(message = "empleado_id es requerido")
    private Long empleadoId;
    @JsonProperty("zona_id")
    @NotBlank(message = "zona_id es requerido")
    private Long zonaId;
    @JsonProperty("vehiculos_asignados")
    @NotBlank(message = "vehiculos_asignados es requerido")
    private int vehiculosAsignados;

}
