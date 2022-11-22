package com.turbo.disease_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turbo.disease_management.Entity.Specialize;

public interface SpecializeRepository extends JpaRepository<Specialize, String>{
	public Specialize findByEmail(String email);
}
