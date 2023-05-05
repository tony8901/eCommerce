package com.ecommerce.backend.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link com.ecommerce.backend.entities.Product} entity
 */
@Data
public class ProductDto implements Serializable {
    private final Long id;
    private final double price;
    private final String name;
    private final Set<CategoryDto> categories;
}