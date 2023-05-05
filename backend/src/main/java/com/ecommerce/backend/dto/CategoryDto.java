package com.ecommerce.backend.dto;

import com.ecommerce.backend.entities.Category;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Category} entity
 */
@Data
public class CategoryDto implements Serializable {
    private final Long id;
    private final String name;
    private final String description;
}