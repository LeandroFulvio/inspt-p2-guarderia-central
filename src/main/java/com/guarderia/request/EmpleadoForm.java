package com.guarderia.request;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Nombre es requerido")
    private String firstname;
    @NotBlank(message = "Apellido es requerido")
    private String lastname;
    @NotBlank(message = "Nombre de Usuario es requerido")
    private String username;
    @NotBlank(message = "Contraseña es requerida")
    private String password;

    //Empleado
    @NotBlank(message = "Codigo es requerido")
    private String codigo;
    private String especialidad;
    private Long dni;
    private String direccion;
    private String telefono;

}
