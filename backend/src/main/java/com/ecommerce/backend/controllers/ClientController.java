package com.ecommerce.backend.controllers;

import com.ecommerce.backend.entities.Client;
import com.ecommerce.backend.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/clients")
@PreAuthorize("hasRole('ADMIN')")
public class ClientController {

    @Autowired
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return clientService.findAll();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        return clientService.findByName(name);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return clientService.findById(id);
    }

    @GetMapping("/surname/{surname}")
    public ResponseEntity<?> findBySurname(@PathVariable String surname){
        return clientService.findBySurname(surname);
    }

    @GetMapping("/second-surname/{secondSurname}")
    public ResponseEntity<?> findBySecondSurname(@PathVariable String secondSurname){
        return clientService.findBySecondSurname(secondSurname);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Client client){
        return clientService.saveWithoutCheckName(client);
    }

    @DeleteMapping("/delete-id/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return clientService.deleteById(id);
    }

}
