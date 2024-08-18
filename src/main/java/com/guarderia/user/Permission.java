package com.guarderia.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    EMPLEADO_READ("empleado:read"),
    EMPLEADO_UPDATE("empleado:update"),
    EMPLEADO_CREATE("empleado:create"),
    EMPLEADO_DELETE("empleado:delete"),
    SOCIO_READ("socio:read"),
    SOCIO_UPDATE("socio:update"),
    SOCIO_CREATE("socio:create"),
    SOCIO_DELETE("socio:delete")
    ;

    @Getter
    private final String permission;

}
