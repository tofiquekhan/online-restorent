package com.webkorps.onlinerestorent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webkorps.onlinerestorent.entity.Membership;
import com.webkorps.onlinerestorent.repository.MembershipRepository;
import com.webkorps.onlinerestorent.service.MembershipService;

@Service
public class MembershipServiceImpl implements MembershipService {

	@Autowired
	private MembershipRepository membershipRepository;
	
	@Override
	public List<Membership> getAllMembership(){
		return membershipRepository.findAll();
	}
	
	
}
