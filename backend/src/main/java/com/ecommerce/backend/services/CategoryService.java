package com.ecommerce.backend.services;

import com.ecommerce.backend.entities.Category;
import com.ecommerce.backend.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BasicServicesNamedEntity<Category, Long> {

    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        super(categoryRepository, "Category");
        this.categoryRepository = categoryRepository;
    }

}
