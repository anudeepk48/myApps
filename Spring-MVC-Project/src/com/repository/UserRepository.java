package com.repository;

import java.util.List;

import com.model.User;


public interface UserRepository {
	
	void save(User user);
	List<User> list();
	User get(Long id);
	
}
