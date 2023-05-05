package com.ecommerce.backend.security.repositories;

import com.ecommerce.backend.security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);
}
