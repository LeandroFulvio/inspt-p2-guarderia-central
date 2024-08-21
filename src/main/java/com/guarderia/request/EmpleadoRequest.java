package com.guarderia.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmpleadoRequest {

    private Long id;
    private String codigo;
    private String especialidad;
    private Long dni;
    private String direccion;
    private String telefono;
    @JsonProperty("user_id")
    private Integer userId;

}
