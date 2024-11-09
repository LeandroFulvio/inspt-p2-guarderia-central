package com.guarderia.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoForm {

    //User
    private String firstname;
    private String lastname;
    private String username;
    private String password;

    //Empleado
    private String codigo;
    private String especialidad;
    private Long dni;
    private String direccion;
    private String telefono;

}
