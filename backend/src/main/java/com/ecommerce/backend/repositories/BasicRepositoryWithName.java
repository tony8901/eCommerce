package com.ecommerce.backend.repositories;

import com.ecommerce.backend.entities.NamedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BasicRepositoryWithName<T extends NamedEntity, ID> extends JpaRepository<T, ID> {
    T findByName(String name);

    boolean existsByName(String name);

    void deleteByName(String name);
}
