package com.ecommerce.backend.repositories;

import com.ecommerce.backend.entities.Discount;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends BasicRepositoryWithName<Discount, Long> {
}