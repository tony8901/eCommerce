package com.ecommerce.backend.repositories;

import com.ecommerce.backend.entities.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BasicRepositoryWithName<Product, Long> {

}