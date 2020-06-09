package com.bookstore.user.dao;

import java.util.Map;

import com.bookstore.user.model.User;

public interface UserRepository {

	void save(User user);

	Map<Integer, User> findAll();

	User findById(int Uid);

	void update(User user);

	void delete(int Uid);
}