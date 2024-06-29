package com.guarderia.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class SocioRequest {

    private Long id;
    private List<VehiculoRequest> vehiculos;
    private Long dni;
    private String direccion;
    private String telefono;
    @JsonProperty("user_id")
    private Long userId;

}
