package com.webkorps.onlinerestorent.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "client")
@Data
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",length = 10)
	private Long id;
	
	@Column(name = "name",length = 50)
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password",length = 16)
	private String password;
	
	@Column(name = "phone_number",length =10 )
	private Long phoneNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Membership membership;
	
	@OneToOne
	private Restro restro;
	
}
