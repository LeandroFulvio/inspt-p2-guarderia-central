package com.guarderia.controler;

import com.guarderia.request.EmpleadoRequest;
import com.guarderia.service.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/empleado")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService service;

    @GetMapping
    public ResponseEntity<?> findAllVehicles(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody EmpleadoRequest request){
        service.save(request);

        return ResponseEntity
                .accepted()
                .build();
    }

    //update
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody EmpleadoRequest request){
        service.update(id, request);

        return ResponseEntity
                .accepted()
                .build();
    }

    //delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteZona(@PathVariable Long id){

        service.deleteById(id);


        return ResponseEntity
                .accepted()
                .build();
    }
}
