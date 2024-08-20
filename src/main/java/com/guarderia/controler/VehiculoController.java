package com.guarderia.controler;

import com.guarderia.request.VehiculoRequest;
import com.guarderia.service.VehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vehiculo")
@RequiredArgsConstructor
public class VehiculoController {

    private final VehiculoService service;

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('socio:read') or hasAuthority('empleado:read')")
    public ResponseEntity<?> findAllVehicles(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('socio:read') or hasAuthority('empleado:read')")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(value = "/{id}/socio")
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('socio:read') or hasAuthority('empleado:read')")
    public ResponseEntity<?> findBySocioId(@PathVariable Long id){
        return ResponseEntity.ok(service.findBySocioId(id));
    }

    //create
    @PostMapping
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<?> create(@RequestBody VehiculoRequest request){
        return ResponseEntity.ok(service.save(request));
    }

    //update
    @PutMapping(value = "/{id}", produces = "application/json")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<?> update(@PathVariable Long id,
                                        @RequestBody VehiculoRequest vehiculo){
        service.update(id, vehiculo);

        return ResponseEntity
                .accepted()
                .build();
    }

    //delete
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity<?> deleteZona(@PathVariable Long id){

        service.deleteById(id);


        return ResponseEntity
                .accepted()
                .build();
    }

}
