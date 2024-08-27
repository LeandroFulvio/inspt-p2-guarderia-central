package com.guarderia.controler;

import com.guarderia.request.GarageRequest;
import com.guarderia.request.VehiculoRequest;
import com.guarderia.service.GarageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/garage")
@RequiredArgsConstructor
public class GarageController {

    private final GarageService service;

    @GetMapping
    public ResponseEntity<?> findAllGarages(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(value = "/{id}/socio")
    public ResponseEntity<?> findBySocioId(@PathVariable Long id){
        return ResponseEntity.ok(service.findBySocioId(id));
    }

    @GetMapping(value = "/{id}/vehiculo")
    public ResponseEntity<?> findByVehiculoId(@PathVariable Long id){
        return ResponseEntity.ok(service.findByVehiculoId(id));
    }

    @GetMapping(value = "/{id}/zona")
    public ResponseEntity<?> findByZonaId(@PathVariable Long id){
        return ResponseEntity.ok(service.findByZonaId(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody GarageRequest request){
        return ResponseEntity.ok(service.create(request));
    }

    @PostMapping(value = "/batch", produces = "application/json")
    public ResponseEntity<?> create(@RequestBody List<GarageRequest> request){
        return ResponseEntity.ok(service.saveAll(request));
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody GarageRequest garage){
        return ResponseEntity.ok(service.update(id, garage));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteZona(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity
                .accepted()
                .build();
    }

    @PostMapping(value = "/{id}/socio/{socio_id}", produces = "application/json")
    public ResponseEntity<?> garagePurchase(@PathVariable Long id,
                                            @PathVariable Long socio_id){

        return ResponseEntity.ok(service.garagePurchase(id, socio_id));
    }

    @PostMapping(value = "/{id}/vehiculo", produces = "application/json")
    public ResponseEntity<?> vehicleIngress(@PathVariable Long id,
                                            @RequestBody VehiculoRequest vehiculo){

        return ResponseEntity.ok(service.vehicleIngress(id, vehiculo));
    }

    //vehicle egress
    @PostMapping(value = "/{id}/liberar", produces = "application/json")
    public ResponseEntity<?> vehicleEgress(@PathVariable Long id){

        return ResponseEntity.ok(service.vehicleEgress(id));
    }
}
