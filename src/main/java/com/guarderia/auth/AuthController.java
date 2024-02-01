package com.guarderia.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest request
    ){
        return new ResponseEntity<>(service.register(request), HttpStatus.CREATED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> register(
            @RequestBody AuthRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }


}
