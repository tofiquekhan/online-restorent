package com.webkorps.onlinerestorent.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webkorps.onlinerestorent.entity.User;
import com.webkorps.onlinerestorent.repository.UserRepository;
import com.webkorps.onlinerestorent.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public User addUser(User user) {
		
		User savedUser = userRepository.save(user);
		return savedUser;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = userRepository.findByEmail(email);
		return user;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
}
