package com.alura.flix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.flix.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}
