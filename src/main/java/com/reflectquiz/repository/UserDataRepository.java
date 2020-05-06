package com.reflectquiz.repository;

import java.util.List;

import com.reflectquiz.model.User;

public interface UserDataRepository {
	List<User> getAllUsers();
	void insertUser(User inputUser);
	User getUserByUsername(String inputUser);
}
