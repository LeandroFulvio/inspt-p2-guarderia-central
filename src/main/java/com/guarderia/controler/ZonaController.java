package com.guarderia.controler;

import com.guarderia.request.ZonaRequest;
import com.guarderia.service.ZonaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/zona")
@RequiredArgsConstructor
public class ZonaController {

    private final ZonaService service;

    @GetMapping
//    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('empleado:read')")
    public ResponseEntity<?> findAllZonas(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}", produces = "application/json")
//    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('empleado:read')")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping(consumes = "application/json")
//    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<?> create(@RequestBody @Valid ZonaRequest request){
        return ResponseEntity.ok(service.save(request));
    }

    @PutMapping(value = "/{id}", produces = "application/json")
//    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<?> update(@PathVariable Long id,
                                        @RequestBody ZonaRequest zona){
        return ResponseEntity.ok(service.update(id, zona));
    }

    @DeleteMapping(value = "/{id}")
//    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.deleteById(id);

        return ResponseEntity
                .accepted()
                .build();
    }


}
