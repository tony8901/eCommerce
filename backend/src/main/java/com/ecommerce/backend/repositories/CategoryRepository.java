package com.ecommerce.backend.repositories;

import com.ecommerce.backend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BasicRepositoryWithName<Category, Long> {

}