package com.ecommerce.backend.security.service;

import com.ecommerce.backend.security.entities.Role;
import com.ecommerce.backend.security.entities.User;
import com.ecommerce.backend.security.jwt.JwtTokenUtil;
import com.ecommerce.backend.security.payload.JwtResponse;
import com.ecommerce.backend.security.payload.LoginRequest;
import com.ecommerce.backend.security.payload.MessageResponse;
import com.ecommerce.backend.security.payload.RegisterRequest;
import com.ecommerce.backend.security.repositories.RoleRepository;
import com.ecommerce.backend.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private final AuthenticationManager authManager;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder encoder;

    @Autowired
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    RoleRepository roleRepository;

    public AuthServiceImpl(AuthenticationManager authManager,
                           UserRepository userRepository,
                           PasswordEncoder encoder,
                           JwtTokenUtil jwtTokenUtil) {
        this.authManager = authManager;
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public ResponseEntity<?> login(LoginRequest loginRequest) {
        try {
            final Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            final String jwt = jwtTokenUtil.generateJwtToken(authentication);

            return ResponseEntity.ok(new JwtResponse(jwt));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong username or password!");
        }
    }

    public ResponseEntity<?> register(RegisterRequest signUpRequest) {
        User user = signUpRequest.getUser();

        try{
        // Check 1: username
        if (userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already in use!"));
        }

        // Check 2: email
        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        user.setPassword(encoder.encode(user.getPassword()));

        Role role = roleRepository.findRoleByName("USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);

        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong: "+e.getMessage());
        }
    }
}
