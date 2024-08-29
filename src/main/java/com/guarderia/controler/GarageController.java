package com.guarderia.controler;

import com.guarderia.request.GarageRequest;
import com.guarderia.request.VehiculoRequest;
import com.guarderia.service.GarageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/garage")
@RequiredArgsConstructor
public class GarageController {

    private final GarageService service;

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('empleado:read') or hasAuthority('socio:read')")
    public ResponseEntity<?> findAllGarages(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('empleado:read') or hasAuthority('socio:read')")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(value = "/{id}/socio")
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('empleado:read') or hasAuthority('socio:read')")
    public ResponseEntity<?> findBySocioId(@PathVariable Long id){
        return ResponseEntity.ok(service.findBySocioId(id));
    }

    @GetMapping(value = "/{id}/vehiculo")
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('empleado:read') or hasAuthority('socio:read')")
    public ResponseEntity<?> findByVehiculoId(@PathVariable Long id){
        return ResponseEntity.ok(service.findByVehiculoId(id));
    }

    @GetMapping(value = "/{id}/zona")
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('empleado:read') or hasAuthority('socio:read')")
    public ResponseEntity<?> findByZonaId(@PathVariable Long id){
        return ResponseEntity.ok(service.findByZonaId(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<?> create(@RequestBody GarageRequest request){
        return ResponseEntity.ok(service.create(request));
    }

    @PostMapping(value = "/batch", produces = "application/json")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<?> create(@RequestBody List<GarageRequest> request){
        return ResponseEntity.ok(service.saveAll(request));
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody GarageRequest garage){
        return ResponseEntity.ok(service.update(id, garage));
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity<?> deleteZona(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity
                .accepted()
                .build();
    }

    @PostMapping(value = "/{id}/socio/{socio_id}", produces = "application/json")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<?> garagePurchase(@PathVariable Long id,
                                            @PathVariable(name = "socio_id") Long socioId){

        return ResponseEntity.ok(service.garagePurchase(id, socioId));
    }

    @PostMapping(value = "/{id}/vehiculo", produces = "application/json")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<?> vehicleIngress(@PathVariable Long id,
                                            @RequestBody VehiculoRequest vehiculo){

        return ResponseEntity.ok(service.vehicleIngress(id, vehiculo));
    }

    @PostMapping(value = "/{id}/liberar", produces = "application/json")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<?> vehicleEgress(@PathVariable Long id){

        return ResponseEntity.ok(service.vehicleEgress(id));
    }
}
