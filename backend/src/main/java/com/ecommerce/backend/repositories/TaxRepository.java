package com.ecommerce.backend.repositories;

import com.ecommerce.backend.entities.Tax;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository extends BasicRepositoryWithName<Tax, Long> {
}