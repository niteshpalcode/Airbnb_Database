package com.airbnb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbnb.Model.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer>{

}
