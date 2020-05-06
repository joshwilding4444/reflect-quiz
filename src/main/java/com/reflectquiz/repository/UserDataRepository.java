package com.reflectquiz.repository;

import java.util.List;

import com.reflectquiz.model.User;

public interface UserDataRepository {
	public abstract List<User> getAllUsers();
	public abstract void insertUser(User inputUser);
	public abstract User getUserByUsername(String inputUser);
}
