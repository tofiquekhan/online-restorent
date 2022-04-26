package com.webkorps.onlinerestorent.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webkorps.onlinerestorent.dto.UserDto;
import com.webkorps.onlinerestorent.entity.User;
import com.webkorps.onlinerestorent.repository.UserRepository;
import com.webkorps.onlinerestorent.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto addUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		User savedUser = userRepository.save(user);
		UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
		return savedUserDto;
	
	
	
	}

	
}
