package com.guarderia.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmpleadoRequest {

    private Long id;
    private String codigo;
    private String especialidad;
    private Long dni;
    private String direccion;
    private String telefono;

    //Zonas asignadas?

    @JsonProperty("user_id")
    private Long userId;

}
