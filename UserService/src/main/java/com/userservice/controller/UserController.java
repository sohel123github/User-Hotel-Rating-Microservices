package com.userservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.dao.UserRepository;
import com.userservice.entity.User;
import com.userservice.service.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser = userServiceImpl.getAll();
		return new ResponseEntity<>(allUser,HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String  userId){
		User user = userServiceImpl.get(userId);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user){
		User u = userServiceImpl.upsert(user);
		return new ResponseEntity<>(u,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User u = userServiceImpl.upsert(user);
		return new ResponseEntity<>(u,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId){
		String u = userServiceImpl.delete(userId);
		return new ResponseEntity<>(u,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
}
