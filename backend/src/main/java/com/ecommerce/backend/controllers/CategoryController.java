package com.ecommerce.backend.controllers;

import com.ecommerce.backend.entities.Category;
import com.ecommerce.backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/api/admin/categories")
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        return categoryService.findByName(name);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return categoryService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Category category){
        return categoryService.save(category);
    }

    @DeleteMapping("/delete-id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return categoryService.deleteById(id);
    }

    @DeleteMapping("/delete-name/{name}")
    public ResponseEntity<?> deleteByName(@PathVariable String name){
        return categoryService.deleteByName(name);
    }
}
