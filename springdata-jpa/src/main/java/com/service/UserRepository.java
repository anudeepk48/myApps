package com.service;

import org.springframework.data.repository.CrudRepository;

import com.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User getUserByEmail(String email);
	User findByEmailAndPasswordHash(String email,String password);
}
