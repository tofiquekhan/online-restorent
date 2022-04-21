package com.webkorps.onlinerestorent.dto;

import lombok.Data;

@Data
public class ClientDto {

	private Long id;
	private String name;
	private String email;
	private String password;
	private Long phoneNumber;
	private MembershipDto membershipDto;
	private RestroDto restroDto;
}
