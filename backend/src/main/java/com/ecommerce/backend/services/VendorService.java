package com.ecommerce.backend.services;

import com.ecommerce.backend.entities.Vendor;
import com.ecommerce.backend.repositories.VendorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendorService extends BasicServicesNamedEntity<Vendor, Long> {

    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        super(vendorRepository, "Vendor");
        this.vendorRepository = vendorRepository;
    }

    public ResponseEntity<?> findBySurname(String surname){
        try {
            Optional<Object> optional = Optional.ofNullable(vendorRepository.findBySurname(surname));
            return optional.map(
                            o -> new ResponseEntity<>(o, HttpStatus.OK))
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vendor not found with surname: " + surname));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong! -> " + e.getMessage());
        }
    }

    public ResponseEntity<?> findBySecondSurname(String secondSurname){
        try {
            Optional<Object> optional = Optional.ofNullable(vendorRepository.findBySecondSurname(secondSurname));
            return optional.map(
                            o -> new ResponseEntity<>(o, HttpStatus.OK))
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vendor not found with second surname: " + secondSurname));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong! -> " + e.getMessage());
        }
    }

}
