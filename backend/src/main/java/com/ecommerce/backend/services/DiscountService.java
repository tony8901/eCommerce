package com.ecommerce.backend.services;

import com.ecommerce.backend.entities.Discount;
import com.ecommerce.backend.repositories.DiscountRepository;
import org.springframework.stereotype.Service;

@Service
public class DiscountService extends BasicServicesNamedEntity<Discount, Long> {

    public DiscountService(DiscountRepository discountRepository) {
        super(discountRepository, "Discount");
    }

}
