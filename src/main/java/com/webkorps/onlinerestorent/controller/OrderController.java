package com.webkorps.onlinerestorent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

	@GetMapping("/client/restro/order")
	public String viewOrderPage() {
		return "viewOrders";
	}
	
	@GetMapping("/user/myorder")
	public String userMyOrderPage() {
		return "userMyOrder";
	}
	
}
