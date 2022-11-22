package com.turbo.disease_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turbo.disease_management.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
