package com.ecommerce.backend.repositories;

import com.ecommerce.backend.entities.Vendor;

public interface VendorRepository extends BasicRepositoryWithName<Vendor, Long>{
    Vendor findBySurname(String surname);

    Vendor findBySecondSurname(String secondSurname);
}
