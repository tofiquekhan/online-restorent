package com.webkorps.onlinerestorent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotificationController {

	@GetMapping("/client/restro/notification")
	public String viewOrderPage() {
		return "notification";
	}
	
	@GetMapping("/user/notification")
	public String myOrderPage() {
		return "userNotification";
	}
}
