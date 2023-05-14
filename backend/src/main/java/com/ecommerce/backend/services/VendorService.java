package com.ecommerce.backend.services;

import com.ecommerce.backend.entities.Vendor;
import com.ecommerce.backend.repositories.VendorRepository;
import org.springframework.stereotype.Service;
@Service
public class VendorService extends BasicServices<Vendor, Long> {

    public VendorService(VendorRepository vendorRepository) {
        super(vendorRepository, "Vendor");
    }

}
