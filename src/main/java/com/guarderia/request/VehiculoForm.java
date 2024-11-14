package com.guarderia.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class VehiculoForm {

    private Long id;

    @NotBlank(message = "matricula es requerida")
    private String matricula;

    @NotBlank(message = "nombre es requerido")
    private String nombre;

    @NotBlank(message = "Tipo Vehiculo es requerido")
    private Long tipoVehiculoId;

    private Date fechaAsignacion;

    private Long idSocio;

}
