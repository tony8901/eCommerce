package com.ecommerce.backend.services;

import com.ecommerce.backend.entities.Product;
import com.ecommerce.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<?> findAll() {
        Optional<Object> optional = Optional.of(productRepository.findAll());
        return optional.map(
                        o -> new ResponseEntity<>(o, HttpStatus.OK))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Products not found!"));
    }

    public ResponseEntity<?> findByName(String name) {
        try {
            Optional<Object> optional = Optional.ofNullable(productRepository.findByName(name));
            return optional.map(
                            o -> new ResponseEntity<>(o, HttpStatus.OK))
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found with name: " + name));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong! -> " + e.getMessage());
        }
    }

    public ResponseEntity<?> findById(Long id) {
        try {
            if(productRepository.existsById(id)){
                return ResponseEntity.status(HttpStatus.OK).body(productRepository.findById(id));
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found with id: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong! -> " + e.getMessage());
        }
    }

    public ResponseEntity<?> save(Product product) {
        try {
            if(productRepository.existsByName(product.getName())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is already a product with that name!");
            }
            return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(product));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong! -> " + e.getLocalizedMessage());
        }
    }

    public ResponseEntity<?> deleteById(Long id) {
        try {
            if (productRepository.existsById(id)) {
                productRepository.deleteById(id);
                return ResponseEntity.status(HttpStatus.OK).body("Product deleted!");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found with id: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong! -> " + e.getMessage());
        }
    }

    public ResponseEntity<?> deleteByName(String name) {
        try {
            if (productRepository.existsByName(name)) {
                productRepository.deleteByName(name);
                return ResponseEntity.status(HttpStatus.OK).body("Product deleted!");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found with name: " + name);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong! -> " + e.getMessage());
        }
    }

}
