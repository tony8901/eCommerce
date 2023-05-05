package com.ecommerce.backend.security.service;

import com.ecommerce.backend.security.payload.LoginRequest;
import com.ecommerce.backend.security.payload.RegisterRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<?> login(LoginRequest loginRequest);

    ResponseEntity<?> register(RegisterRequest registerRequest);
}
