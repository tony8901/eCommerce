package com.ecommerce.backend.security.controllers;

import com.ecommerce.backend.security.payload.LoginRequest;
import com.ecommerce.backend.security.payload.RegisterRequest;
import com.ecommerce.backend.security.service.AuthServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para llevar a cabo la autenticación utilizando JWT *
 * Se utiliza AuthenticationManager para autenticar las credenciales que son el
 * usuario y password que llegan por POST en el cuerpo de la petición
 * Si las credenciales son válidas se genera un token JWT como respuesta
 */
// @CrossOrigin(origins = "http://localhost:8080/api/auth")

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    private final AuthServiceImpl authServiceImpl;

    public AuthController(AuthServiceImpl authServiceImpl) {
        this.authServiceImpl = authServiceImpl;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return authServiceImpl.login(loginRequest);
    }

    @GetMapping("/login")
    public ResponseEntity<String> loginGet(){
        return ResponseEntity.ok("Welcome to login :) ");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest signUpRequest) {
        return authServiceImpl.register(signUpRequest);
    }
}
