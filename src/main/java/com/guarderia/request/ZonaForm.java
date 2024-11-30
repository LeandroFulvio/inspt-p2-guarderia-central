package com.guarderia.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ZonaForm {

    @NotBlank(message = "letra es requerida")
    private String letra; //Identificador local de la Zona

    @Min(value = 1, message = "La capacidad debe ser al menos 1")
    private int capacidad;

//    @Min(value = 1, message = "El ancho debe ser al menos 1")
//    private int ancho;
//
//    @Min(value = 1, message = "La profundidad debe ser al menos 1")
//    private int profundidad;

    @NotEmpty(message = "Debe seleccionar al menos un tipo de vehículo admitido")
    private Long[] tipoVehiculoAdmitidos;

}
