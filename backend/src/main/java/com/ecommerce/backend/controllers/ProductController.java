package com.ecommerce.backend.controllers;

import com.ecommerce.backend.entities.Product;
import com.ecommerce.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/products")
@PreAuthorize("hasRole('ADMIN')")
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return productService.findAll();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        return productService.findByName(name);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/delete-id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return productService.deleteById(id);
    }

    @DeleteMapping("/delete-name/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable String name){
        return productService.deleteByName(name);
    }

}
