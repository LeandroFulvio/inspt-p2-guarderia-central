package com.guarderia.controler;

import com.guarderia.service.TipoVehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tipovehiculo")
@RequiredArgsConstructor
public class TipoVehiculoController {

    private final TipoVehiculoService service;

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('socio:read') or hasAuthority('empleado:read')")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('socio:read') or hasAuthority('empleado:read')")
    public ResponseEntity<?> findById(){
        return ResponseEntity.ok(service.findAll());
    }

}
