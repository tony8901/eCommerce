package com.ecommerce.backend.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class BasicServices<T , ID> {

    private final JpaRepository<T, ID> jpaRepository;

    private final String NAME_ENTITY;

    public BasicServices(JpaRepository<T,ID> jpaRepository, String nameEntity) {
        this.jpaRepository = jpaRepository;
        NAME_ENTITY = nameEntity;
    }

    public ResponseEntity<?> save(T entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(jpaRepository.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong! -> " + e.getLocalizedMessage());
        }
    }

    public ResponseEntity<?> findAll() {
        Optional<Object> optional = Optional.of(jpaRepository.findAll());
        return optional.map(
                        o -> new ResponseEntity<>(o, HttpStatus.OK))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(NAME_ENTITY+" not found!"));
    }

    public ResponseEntity<?> findById(ID id) {
        try {
            if(jpaRepository.existsById(id)){
                return ResponseEntity.status(HttpStatus.OK).body(jpaRepository.findById(id));
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(NAME_ENTITY+" not found with id: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong! -> " + e.getMessage());
        }
    }

    public ResponseEntity<?> deleteById(ID id) {
        try {
            if (jpaRepository.existsById(id)) {
                jpaRepository.deleteById(id);
                return ResponseEntity.status(HttpStatus.OK).body(NAME_ENTITY+" deleted!");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(NAME_ENTITY+" not found with id: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong! -> " + e.getMessage());
        }
    }

}
