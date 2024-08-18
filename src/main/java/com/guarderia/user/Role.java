package com.guarderia.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.guarderia.user.Permission.*;

@RequiredArgsConstructor
public enum Role {

    USER(Collections.emptySet()),
    ADMIN(Set.of(
            ADMIN_READ,
            ADMIN_UPDATE,
            ADMIN_DELETE,
            ADMIN_CREATE,
            SOCIO_READ,
            SOCIO_UPDATE,
            SOCIO_DELETE,
            SOCIO_CREATE,
            EMPLEADO_READ,
            EMPLEADO_UPDATE,
            EMPLEADO_DELETE,
            EMPLEADO_CREATE
    )),
    EMPLEADO(Set.of(
            EMPLEADO_READ,
            EMPLEADO_UPDATE,
            EMPLEADO_DELETE,
            EMPLEADO_CREATE
    )),
    SOCIO(Set.of(
            SOCIO_READ,
            SOCIO_UPDATE,
            SOCIO_DELETE,
            SOCIO_CREATE
    ));

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }

}
