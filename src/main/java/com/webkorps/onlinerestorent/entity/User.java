package com.webkorps.onlinerestorent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="user")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",length = 10)
	private Long id;
	
	@Column(name = "name",length = 35)
	@NotBlank(message = "You can not Sign Up without Full Name") @NotNull
	private String name;
	
	@Column(name = "email")
	@Email() @NotNull
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "phone_number",length =10 )
	private Long phoneNumber;
	
	@Column(name = "role")
	private String role;

}
