package com.ecommerce.backend.services;

import com.ecommerce.backend.entities.NamedEntity;
import com.ecommerce.backend.repositories.BasicRepositoryWithName;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class BasicServicesNamedEntity<T extends NamedEntity, ID> {

    private final BasicRepositoryWithName<T, ID> basicRepositoryWithName;

    private final String NAME_ENTITY;

    public BasicServicesNamedEntity(BasicRepositoryWithName<T,ID> basicRepositoryWithName, String nameEntity) {
        this.basicRepositoryWithName = basicRepositoryWithName;
        NAME_ENTITY = nameEntity;
    }

    public ResponseEntity<?> save(T entity) {
        try {
            if(basicRepositoryWithName.existsByName(entity.getName())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is already a "+NAME_ENTITY+" with that name!");
            }
            return ResponseEntity.status(HttpStatus.OK).body(basicRepositoryWithName.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong! -> " + e.getLocalizedMessage());
        }
    }

    public ResponseEntity<?> saveWithoutCheckName(T entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(basicRepositoryWithName.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong! -> " + e.getLocalizedMessage());
        }
    }

    public ResponseEntity<?> findAll() {
        Optional<Object> optional = Optional.of(basicRepositoryWithName.findAll());
        return optional.map(
                        o -> new ResponseEntity<>(o, HttpStatus.OK))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(NAME_ENTITY+" not found!"));
    }

    public ResponseEntity<?> findByName(String name) {
        try {
            List<T> elements = basicRepositoryWithName.findByNameIgnoreCase(name);

            return elements.isEmpty()
                    ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(NAME_ENTITY+" not found with name: " + name)
                    : ResponseEntity.ok(elements);


//            Optional<Object> optional = Optional.ofNullable(basicRepositoryWithName.findByNameIgnoreCase(name));
//            return optional.map(
//                            o -> new ResponseEntity<>(o, HttpStatus.OK))
//                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(NAME_ENTITY+" not found with name: " + name));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong! -> " + e.getMessage());
        }
    }

    public ResponseEntity<?> findById(ID id) {
        try {

            return basicRepositoryWithName.existsById(id)
                    ? ResponseEntity.ok(basicRepositoryWithName.findById(id))
                    : ResponseEntity.status(HttpStatus.NOT_FOUND).body(NAME_ENTITY+" not found with id: " + id);

//            Optional<Object> optional = Optional.of(basicRepositoryWithName.findById(id));
//            return optional.map(ResponseEntity::ok)
//                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(NAME_ENTITY+" not found with id: " + id));

//            if(basicRepositoryWithName.existsById(id)){
//                return ResponseEntity.status(HttpStatus.OK).body(basicRepositoryWithName.findById(id));
//            }
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(NAME_ENTITY+" not found with id: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong! -> " + e.getMessage());
        }
    }

    public ResponseEntity<?> deleteById(ID id) {
        try {
            if (basicRepositoryWithName.existsById(id)) {
                basicRepositoryWithName.deleteById(id);
                return ResponseEntity.status(HttpStatus.OK).body(NAME_ENTITY+" deleted!");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(NAME_ENTITY+" not found with id: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong! -> " + e.getCause());
        }
    }

    public ResponseEntity<?> deleteByName(String name) {
        try {
            if (basicRepositoryWithName.existsByName(name)) {
                basicRepositoryWithName.deleteByName(name);
                return ResponseEntity.status(HttpStatus.OK).body(NAME_ENTITY+" deleted!");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(NAME_ENTITY+" not found with name: " + name);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong! -> " + e.getMessage());
        }
    }


}
