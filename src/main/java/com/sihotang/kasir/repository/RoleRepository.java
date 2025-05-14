package com.sihotang.kasir.repository;

import com.sihotang.kasir.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Add custom query methods if needed
} 