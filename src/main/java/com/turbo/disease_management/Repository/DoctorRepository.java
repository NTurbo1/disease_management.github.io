package com.turbo.disease_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turbo.disease_management.Entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, String>{
	public Doctor findByEmail(String email);
}

