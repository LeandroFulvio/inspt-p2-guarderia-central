package com.guarderia.controler;

import com.guarderia.request.GarageRequest;
import com.guarderia.service.GarageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/garage")
@RequiredArgsConstructor
public class GarageController {

    private final GarageService service;

    @GetMapping
    public ResponseEntity<?> findAllVehicles(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    //Get garage by socio - query param?

    @PostMapping
    public ResponseEntity<?> create(@RequestBody GarageRequest request){
        service.save(request);

        return ResponseEntity
                .accepted()
                .build();
    }

    //update
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody GarageRequest garage){
        service.update(id, garage);

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
