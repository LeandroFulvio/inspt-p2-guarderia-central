package com.guarderia.controler;

import com.guarderia.request.AsignacionZonaRequest;
import com.guarderia.service.AsignacionZonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/asignar")
@RequiredArgsConstructor
public class AsignacionZonaController {

    private final AsignacionZonaService service;

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('empleado:read')")
    public ResponseEntity<?> findAllAsignaciones(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('empleado:read')")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin:create') or hasAuthority('empleado:create')")
    public ResponseEntity<?> create(@RequestBody AsignacionZonaRequest request){
        return ResponseEntity.ok(service.save(request));
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    @PreAuthorize("hasAuthority('admin:update') or hasAuthority('empleado:update')")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody AsignacionZonaRequest asignacion){
        return ResponseEntity.ok(service.update(id, asignacion));
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin:delete') or hasAuthority('empleado:delete')")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity
                .accepted()
                .build();
    }

}
