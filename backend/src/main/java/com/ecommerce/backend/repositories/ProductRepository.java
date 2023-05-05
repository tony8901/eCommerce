package com.ecommerce.backend.repositories;

import com.ecommerce.backend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);

    boolean existsByName(String name);

    void deleteByName(String name);
}