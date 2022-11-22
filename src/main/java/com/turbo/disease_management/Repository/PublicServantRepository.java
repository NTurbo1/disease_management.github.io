package com.turbo.disease_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turbo.disease_management.Entity.PublicServant;

public interface PublicServantRepository extends JpaRepository<PublicServant, String>{
    public PublicServant findByEmail(String email);
}
