package com.webkorps.onlinerestorent.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webkorps.onlinerestorent.entity.MembershipPlan;
import com.webkorps.onlinerestorent.service.MembershipPlanService;

@Controller
public class MembershipPlanController {
	
	@Autowired
	private MembershipPlanService membershipPlanService;
	
	@GetMapping("/admin/membershipplan")
	public String allMembershipPlanPage(ModelMap model) {
		List<MembershipPlan> membershipPlans = membershipPlanService.getMembershipPlans();
		model.addAttribute("membershipPlans", membershipPlans);
		return "allMembershipPlan";
	}
	
	@GetMapping("/admin/addmembershipplan")
	public String addMembershipPlanPage() {
		return "addMembershipPlan";
	}
	
	@PostMapping("/admin/addmembershipplan")
	public String addMembershipPlan(ModelMap model,@RequestParam(name = "membershipPlanName")String membershipPlanName,@RequestParam(name = "membershipPlanPrice") String membershipPlanPrice,@RequestParam(name = "membershipPlanDays")String membershipPlanDays ) {
		MembershipPlan membershipPlan = new MembershipPlan();
		membershipPlan.setName(membershipPlanName);
		membershipPlan.setPrice(Integer.parseInt(membershipPlanPrice));
		membershipPlan.setDays(Integer.parseInt(membershipPlanDays));
		MembershipPlan savedMembershipPlan = membershipPlanService.addMembershipPlan(membershipPlan);
		String msg = "fail";
		if(savedMembershipPlan.getId()>0) {
			msg = "success";
		}
		model.addAttribute("msg", msg);
		return "addMembershipPlan";
	}

}
