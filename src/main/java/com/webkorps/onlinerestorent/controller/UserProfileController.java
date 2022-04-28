package com.webkorps.onlinerestorent.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webkorps.onlinerestorent.entity.User;
import com.webkorps.onlinerestorent.service.UserService;

@Controller
@RequestMapping("/user")
public class UserProfileController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/changepassword")
	public String changePassword(HttpSession session,@RequestParam(name = "newPassword")String newPassword) {
		User user = (User) session.getAttribute("user");
		user.setPassword(bCryptPasswordEncoder.encode(newPassword));
		userService.addUser(user);
		return "userMyAccount";
	}
	
	@PostMapping("/user/delete")
	public String deleteUser(@RequestParam(name = "id")String id) {
		userService.deleteUser(Long.parseLong(id));
		return "index";
	}
}
