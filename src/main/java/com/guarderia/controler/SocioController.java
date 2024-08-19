package com.guarderia.controler;

import com.guarderia.modelo.Socio;
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
    public ResponseEntity<?> findAllVehicles(){
        return ResponseEntity.ok(service.findAll());
    }

    //All vehicles by socio

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody SocioRequest request){
        return ResponseEntity.ok(service.save(request));
    }

    //update
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody SocioRequest request){
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
