package com.guarderia.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo-controller")
public class DemoController {

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('socio:read') or hasAuthority('empleado:read')")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello!");
    }


}
