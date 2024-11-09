package com.guarderia.controller;

import com.guarderia.request.AsignacionZonaRequest;
import com.guarderia.service.AsignacionZonaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/asignar")
@RequiredArgsConstructor
public class AsignacionZonaController {

    private final AsignacionZonaService service;

    @GetMapping
//    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('empleado:read')")
    public ResponseEntity<?> findAllAsignaciones(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
//    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('empleado:read')")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(value = "/{id}/zona")
//    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('empleado:read')")
    public ResponseEntity<?> findByZonaId(@PathVariable Long id){
        return ResponseEntity.ok(service.findByZonaId(id));
    }

    @GetMapping(value = "/{id}/empleado")
//    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('empleado:read')")
    public ResponseEntity<?> findByEmpleadoId(@PathVariable Long id){
        return ResponseEntity.ok(service.findByEmpleadoId(id));
    }

    @PostMapping
//    @PreAuthorize("hasAuthority('admin:create') or hasAuthority('empleado:create')")
    public ResponseEntity<?> create(@RequestBody @Valid AsignacionZonaRequest request){
        return ResponseEntity.ok(service.save(request));
    }

    @PostMapping(value = "/batch")
//    @PreAuthorize("hasAuthority('admin:create') or hasAuthority('empleado:create')")
    public ResponseEntity<?> createAll(@RequestBody List<AsignacionZonaRequest> request){
        return ResponseEntity.ok(service.saveAll(request));
    }

    @PutMapping(value = "/{id}", produces = "application/json")
//    @PreAuthorize("hasAuthority('admin:update') or hasAuthority('empleado:update')")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody @Valid AsignacionZonaRequest request){
        return ResponseEntity.ok(service.update(id, request));
    }

    @PutMapping(value = "/batch")
//    @PreAuthorize("hasAuthority('admin:update') or hasAuthority('empleado:update')")
    public ResponseEntity<?> updateAll(@RequestBody List<AsignacionZonaRequest> request){
        return ResponseEntity.ok(service.updateAll(request));
    }

    @DeleteMapping(value = "/{id}")
//    @PreAuthorize("hasAuthority('admin:delete') or hasAuthority('empleado:delete')")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity
                .accepted()
                .build();
    }

}
