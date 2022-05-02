package com.webkorps.onlinerestorent.service;

import java.util.List;

import com.webkorps.onlinerestorent.entity.MembershipPlan;

public interface MembershipPlanService {
	
	List<MembershipPlan> getMembershipPlans();
	MembershipPlan addMembershipPlan(MembershipPlan membershipPlan);
	MembershipPlan getMembershipPlanById(Long id);
}
