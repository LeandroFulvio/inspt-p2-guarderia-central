package com.guarderia.controler;

import com.guarderia.request.VehiculoRequest;
import com.guarderia.service.VehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vehiculo")
@RequiredArgsConstructor
public class VehiculoController {

    private final VehiculoService service;

    @GetMapping
    public ResponseEntity<?> findAllVehicles(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        return ResponseEntity.ok(service.findById(id));
    }

    //create
    @PostMapping
    public ResponseEntity<?> create(@RequestBody VehiculoRequest request){
        service.save(request);

        return ResponseEntity
                .accepted()
                .build();
    }

    //update
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> update(@PathVariable String id,
                                        @RequestBody VehiculoRequest vehiculo){
        service.update(id, vehiculo);

        return ResponseEntity
                .accepted()
                .build();
    }

    //delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteZona(@PathVariable String id){

        service.deleteById(id);


        return ResponseEntity
                .accepted()
                .build();
    }

}
