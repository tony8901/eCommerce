package com.ecommerce.backend.dto;

import com.ecommerce.backend.security.entities.User;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.ecommerce.backend.entities.Vendor} entity
 */
@Data
public class VendorDto implements Serializable {
    private final Long id;
    private final String name;
    private final String surname;
    private final String secondSurname;
    private final String personalAddress;
    private final User user;
}