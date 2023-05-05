package com.ecommerce.backend.services;

import com.ecommerce.backend.entities.Category;
import com.ecommerce.backend.repositories.CategoryRepository;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.exception.ConstraintViolationException;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ResponseEntity<?> findAll() {
        Optional<Object> optional = Optional.of(categoryRepository.findAll());
        return optional.map(
                        o -> new ResponseEntity<>(o, HttpStatus.OK))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categories not found!"));
    }

    public ResponseEntity<?> findByName(String name) {
        try {
            Optional<Object> optional = Optional.ofNullable(categoryRepository.findByName(name));
            return optional.map(
                            o -> new ResponseEntity<>(o, HttpStatus.OK))
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found with name: " + name));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong! -> " + e.getMessage());
        }
    }

    //no trabaja igual que el findByName, devuelve null cuando no encuentra
    //por eso esta hecho con if()
    public ResponseEntity<?> findById(Long id) {
        try {
            if(categoryRepository.existsById(id)){
                return ResponseEntity.status(HttpStatus.OK).body(categoryRepository.findById(id));
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found with id: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong! -> " + e.getMessage());
        }
    }

    public ResponseEntity<?> save(Category category) {
        try {
            if(categoryRepository.existsByName(category.getName())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is already a category with that name!");
            }
            return ResponseEntity.status(HttpStatus.OK).body(categoryRepository.save(category));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong! -> " + e.getLocalizedMessage());
        }
    }

    public ResponseEntity<?> deleteById(Long id) {
        try {
            if (categoryRepository.existsById(id)) {
                categoryRepository.deleteById(id);
                return ResponseEntity.status(HttpStatus.OK).body("Category deleted!");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("category not found with id: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong! -> " + e.getMessage());
        }
    }

    public ResponseEntity<?> deleteByName(String name) {
        try {
            if (categoryRepository.existsByName(name)) {
                categoryRepository.deleteByName(name);
                return ResponseEntity.status(HttpStatus.OK).body("Category deleted!");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("category not found with name: " + name);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong! -> " + e.getMessage());
        }
    }

}
