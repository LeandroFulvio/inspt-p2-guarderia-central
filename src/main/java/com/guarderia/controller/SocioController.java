package com.guarderia.controller;

import com.guarderia.request.SocioRequest;
import com.guarderia.service.SocioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/socio")
@RequiredArgsConstructor
public class SocioController {

    private final SocioService service;

    @GetMapping
//    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('socio:read') or hasAuthority('empleado:read')")
    public ResponseEntity<?> findAllVehicles(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
//    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('socio:read') or hasAuthority('empleado:read')")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
//    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<?> create(@RequestBody SocioRequest request){
        return ResponseEntity.ok(service.save(request));
    }

    @PutMapping(value = "/{id}", produces = "application/json")
//    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody SocioRequest request){
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping(value = "/{id}")
//    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity<?> deleteZona(@PathVariable Long id){
        service.deleteById(id);

        return ResponseEntity
                .accepted()
                .build();
    }

}
