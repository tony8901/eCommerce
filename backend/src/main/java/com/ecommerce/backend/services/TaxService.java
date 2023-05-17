package com.ecommerce.backend.services;

import com.ecommerce.backend.entities.Tax;
import com.ecommerce.backend.repositories.TaxRepository;
import org.springframework.stereotype.Service;

@Service
public class TaxService extends BasicServicesNamedEntity<Tax, Long> {
    public TaxService(TaxRepository taxRepository) {
        super(taxRepository, "Tax");
    }
}
