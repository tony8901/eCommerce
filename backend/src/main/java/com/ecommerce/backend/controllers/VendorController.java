package com.ecommerce.backend.controllers;

import com.ecommerce.backend.entities.Vendor;
import com.ecommerce.backend.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/vendors")
public class VendorController {

    @Autowired
    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return vendorService.findAll();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        return vendorService.findByName(name);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return vendorService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Vendor entity){
        return vendorService.save(entity);
    }

    @DeleteMapping("/delete-id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return vendorService.deleteById(id);
    }

    @DeleteMapping("/delete-name/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable String name){
        return vendorService.deleteByName(name);
    }


}
