package com.ecommerce.backend.repositories;

import com.ecommerce.backend.entities.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends BasicRepositoryWithName<Client, Long>{
    Client findBySurname(String surname);

    boolean existsBySurname(String surname);

    Client findBySecondSurname(String secondSurname);
}