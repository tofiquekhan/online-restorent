package com.webkorps.onlinerestorent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

	@GetMapping("/user/cart")
	public String userMyOrderPage() {
		return "cart";
	}
}
