package com.MongoDBExample.mdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MongoDBExample.mdb.Repository.UserRepository;
import com.MongoDBExample.mdb.entity.Users;

@RestController
@RequestMapping("/rest/users")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/all")
	public List<Users> getAllUsers(){
		return userRepository.findAll();
	}
	
	@PostMapping("/")
	public Users createUser(@RequestBody Users user) {
		userRepository.save(user);
		return user;
	}
	
	@GetMapping("/{id}")
	public Users getUserById(@PathVariable("id")Integer id) {
		return userRepository.getUserById(id);	
	}
	
	@PutMapping("/{id}")
	public Users modifyUserById(@PathVariable("id")Integer id, @RequestBody Users user) {
		user.setId(id);
		return userRepository.save(user);	
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable("id")Integer id) {
		userRepository.delete(userRepository.getUserById(id));
	}
}
