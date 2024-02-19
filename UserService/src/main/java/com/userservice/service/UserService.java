package com.userservice.service;

import java.util.List;
import com.userservice.entity.User;

public interface UserService {

	public List<User> getAll();
	
	public User get(String userId);
	
	public User upsert(User user);
	
	public String delete(String userId);
	
}
