package com.turbo.disease_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turbo.disease_management.Entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	public User findByEmail(String email);
}
