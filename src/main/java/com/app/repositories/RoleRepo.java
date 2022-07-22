package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Role;

public interface RoleRepo  extends JpaRepository<Role, Integer>{

}
