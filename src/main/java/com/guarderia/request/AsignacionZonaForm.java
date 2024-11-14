package com.guarderia.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AsignacionZonaForm {
    private Long id;

    @NotNull(message = "empleado_id es requerido")
    private Long empleadoId;

    @NotNull(message = "zona_id es requerido")
    private Long zonaId;

    @NotNull(message = "vehiculos_a_cargo es requerido")
    private int vehiculosACargo;

}