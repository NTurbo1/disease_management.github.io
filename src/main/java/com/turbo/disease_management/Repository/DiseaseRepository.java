package com.turbo.disease_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turbo.disease_management.Entity.Disease;

public interface DiseaseRepository extends JpaRepository<Disease, String>{
    public Disease findByDiseaseCode(String diseaseCode);
}
