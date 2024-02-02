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
    public ResponseEntity<?> findById(@PathVariable String id){
        return ResponseEntity.ok(service.findById(id));
    }

    //create
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ZonaRequest request){
        service.save(request);

        return ResponseEntity
            .accepted()
            .build();
    }

    //update
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> update(@PathVariable String id,
                                        @RequestBody ZonaRequest zona){
        service.update(id, zona);

        return ResponseEntity
                .accepted()
                .build();
    }

    //delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){

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
