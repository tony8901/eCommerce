package com.ecommerce.backend.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
Probando las funcionalidades. Puedo definir @PreAuthorize a nivel de clase o en cada metodo
 */
@RestController
@RequestMapping("/api/hello")
//@PreAuthorize("hasRole('ADMIN')")
public class HelloController {

    //Probando la autorizacion por roles
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/hello-admin")
    public String adminPing(){
        return "Only Admins Can Read This";
    }
}
