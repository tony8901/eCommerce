package com.ecommerce.backend.services;

import com.ecommerce.backend.entities.Client;
import com.ecommerce.backend.repositories.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService extends BasicServicesNamedEntity<Client, Long> {

    private final ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository) {
        super(clientRepository, "Client");
        this.clientRepository = clientRepository;
    }

    public ResponseEntity<?> findBySurname(String surname){
        try {
            Optional<Object> optional = Optional.ofNullable(clientRepository.findBySurname(surname));
            return optional.map(
                            o -> new ResponseEntity<>(o, HttpStatus.OK))
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found with surname: " + surname));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong! -> " + e.getMessage());
        }
    }

    public ResponseEntity<?> findBySecondSurname(String secondSurname){
        try {
            Optional<Object> optional = Optional.ofNullable(clientRepository.findBySecondSurname(secondSurname));
            return optional.map(
                            o -> new ResponseEntity<>(o, HttpStatus.OK))
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found with second surname: " + secondSurname));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong! -> " + e.getMessage());
        }
    }
}
