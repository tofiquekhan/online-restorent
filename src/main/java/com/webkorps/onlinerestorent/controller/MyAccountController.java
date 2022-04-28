package com.webkorps.onlinerestorent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyAccountController {

	@GetMapping("/client/myaccount")
	public String clientMyAccountPage() {
		return "myAccount";
	}
	
	@GetMapping("/user/myaccount")
	public String userMyAccountPage() {
		return "userMyAccount";
	}
}
