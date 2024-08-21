package com.guarderia.controler;

import com.guarderia.request.ZonaRequest;
import com.guarderia.service.ZonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/zona")
@RequiredArgsConstructor
public class ZonaController {

    private final ZonaService service;

    //get all
    @GetMapping
    public ResponseEntity<?> findAllZonas(){
        return ResponseEntity.ok(service.findAll());
    }

    //get one
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    //create
    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> create(@RequestBody ZonaRequest request){
        return ResponseEntity.ok(service.save(request));
    }

    //update
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> update(@PathVariable Long id,
                                        @RequestBody ZonaRequest zona){
        service.update(id, zona);

        return ResponseEntity
                .accepted()
                .build();
    }

    //delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.deleteById(id);

        return ResponseEntity
                .accepted()
                .build();
    }
/*
 ResponseEntity.badRequest()
            .body("Year of birth cannot be in the future");

 */

}
