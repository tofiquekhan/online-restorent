package com.webkorps.onlinerestorent.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.webkorps.onlinerestorent.entity.Membership;
import com.webkorps.onlinerestorent.service.MembershipService;

@Controller
public class MembershipController {
	
	@Autowired
	private MembershipService membershipService;

	@GetMapping("/admin/memberships")
	public String allMembershipsPage(HttpSession session,ModelMap model) {
		List<Membership> memberships = membershipService.getAllMembership();
		model.addAttribute("memberships", memberships);
		return "allMembership";
	}
}
