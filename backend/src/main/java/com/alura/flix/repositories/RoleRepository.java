package com.alura.flix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.flix.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
