package com.guarderia.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class GarageForm {

    private Long id;

    @NotNull(message = "Numero es obligatorio")
    @Min(value = 1, message = "Numero debe ser mayor que 0")
    private int numero;

    private int contadorLuz;

    private boolean mantenimientoContratado;

    private Date fechaCompra;

    private Long socioId;

    private Long vehiculoGuardadoId;

    private Long zonaId;

}
