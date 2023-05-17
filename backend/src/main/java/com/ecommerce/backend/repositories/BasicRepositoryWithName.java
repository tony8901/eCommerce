package com.ecommerce.backend.repositories;

import com.ecommerce.backend.entities.NamedEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BasicRepositoryWithName<T extends NamedEntity, ID> extends JpaRepository<T, ID> {
    T findByName(String name);

    boolean existsByName(String name);

    @Transactional
    void deleteByName(String name);
}
