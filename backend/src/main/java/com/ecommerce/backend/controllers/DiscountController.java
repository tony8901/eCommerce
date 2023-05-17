package com.ecommerce.backend.controllers;

import com.ecommerce.backend.entities.Discount;
import com.ecommerce.backend.repositories.BasicRepositoryWithName;
import com.ecommerce.backend.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/discounts")
@PreAuthorize("hasRole('ADMIN')")
public class DiscountController {

    @Autowired
    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return discountService.findAll();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        return discountService.findByName(name);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return discountService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Discount discount){
        return discountService.save(discount);
    }

    @DeleteMapping("/delete-id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return discountService.deleteById(id);
    }

    @DeleteMapping("/delete-name/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable String name){
        return discountService.deleteByName(name);
    }

}
