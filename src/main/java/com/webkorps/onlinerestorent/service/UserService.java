package com.webkorps.onlinerestorent.service;

import com.webkorps.onlinerestorent.entity.User;

public interface UserService {

	User addUser(User user);
	
	User getUserByEmail(String email);
	
	void deleteUser(Long id);
}
