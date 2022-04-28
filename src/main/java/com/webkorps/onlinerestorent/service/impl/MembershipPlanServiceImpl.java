package com.webkorps.onlinerestorent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webkorps.onlinerestorent.entity.MembershipPlan;
import com.webkorps.onlinerestorent.repository.MembershipPlanRepository;
import com.webkorps.onlinerestorent.service.MembershipPlanService;

@Service
public class MembershipPlanServiceImpl implements MembershipPlanService{

	@Autowired
	private MembershipPlanRepository membershipPlanRepository;
	
	@Override
	public List<MembershipPlan> getMembershipPlans(){
		return membershipPlanRepository.findAll();
	}
	
	@Override
	public MembershipPlan addMembershipPlan(MembershipPlan membershipPlan) {
		return membershipPlanRepository.save(membershipPlan);
	}
}
