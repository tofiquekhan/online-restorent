package com.webkorps.onlinerestorent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client/myaccount")
public class MyAccountController {

	@GetMapping
	public String viewOrderPage() {
		return "myAccount";
	}
}
