package com.turbo.disease_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turbo.disease_management.Entity.Discover;

public interface DiscoverRepository extends JpaRepository<Discover, String>{
    public Discover findByDiseaseCode(String diseaseCode);
}
