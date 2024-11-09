package com.guarderia.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SocioFrom {

    //User
    private String firstname;
    private String lastname;
    private String username;
    private String password;

    //Socio
    private Long dni;
    private String direccion;
    private String telefono;

}
