package com.airbnb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbnb.Model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	public Users findByEmail(String email);
}
