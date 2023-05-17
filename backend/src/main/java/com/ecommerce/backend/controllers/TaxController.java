package com.ecommerce.backend.controllers;

import com.ecommerce.backend.entities.Tax;
import com.ecommerce.backend.services.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/taxes")
@PreAuthorize("hasRole('ADMIN')")
public class TaxController {

    @Autowired
    private final TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return taxService.findAll();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        return taxService.findByName(name);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return taxService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Tax tax){
        return taxService.save(tax);
    }

    @DeleteMapping("/delete-id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return taxService.deleteById(id);
    }

    @DeleteMapping("/delete-name/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable String name){
        return taxService.deleteByName(name);
    }

}
