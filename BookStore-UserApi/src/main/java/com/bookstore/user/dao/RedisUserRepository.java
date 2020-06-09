package com.bookstore.user.dao;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.bookstore.user.model.User;

@Repository
public class RedisUserRepository implements UserRepository {

	private RedisTemplate<String, User> redisTemplate;

	private HashOperations hashOperations;

	public RedisUserRepository(RedisTemplate<String, User> redisTemplate) {
		this.redisTemplate = redisTemplate;

		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(User user) {
		hashOperations.put("USER", user.getUId(), user);
	}

	@Override
	public Map<Integer, User> findAll() {
		return hashOperations.entries("USER");
	}

	public User findById(int uId) {
		return (User) hashOperations.get("USER", uId);
	}

	@Override
	public void update(User user) {
		save(user);
	}

	@Override
	public void delete(int uId) {
		hashOperations.delete("USER", uId);
	}
}