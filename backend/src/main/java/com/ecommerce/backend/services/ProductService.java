package com.ecommerce.backend.services;

import com.ecommerce.backend.entities.Product;
import com.ecommerce.backend.repositories.ProductRepository;
import org.springframework.stereotype.Service;


@Service
public class ProductService extends BasicServicesNamedEntity<Product, Long> {

    public ProductService(ProductRepository productRepository) {
        super(productRepository, "Product");
    }

}
