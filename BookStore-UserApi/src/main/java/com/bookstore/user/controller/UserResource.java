package com.bookstore.user.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.user.dao.RedisUserRepository;
import com.bookstore.user.model.User;

@RestController
@RequestMapping("/rest/user")
public class UserResource {

	private RedisUserRepository userRepository;

	public UserResource(RedisUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/add/{uId}/{firstName}")
	public User add(@PathVariable("uId") final int uId, @PathVariable("firstName") final String firstName) {
		userRepository.save(
				new User(uId, firstName, "Yadav", "ritesh", "ry765989@gmail.com", "Male", "7829328684", "Ritesh1194"));
		return userRepository.findById(uId);
	}

	@GetMapping("/update/{uId}/{firstName}")
	public User update(@PathVariable("uId") final int uId, @PathVariable("firstName") final String firstName) {
		userRepository.update(
				new User(uId, firstName, "Yadav", "ritesh", "ry765989@gmail.com", "Male", "7829328684", "Ritesh1194"));
		return userRepository.findById(uId);
	}

	@GetMapping("/delete/{uId}")
	public Map<Integer, User> delete(@PathVariable("uId") final int uId) {
		userRepository.delete(uId);
		return all();
	}

	@GetMapping("/all")
	public Map<Integer, User> all() {
		return (Map<Integer, User>) userRepository.findAll();
	}
}