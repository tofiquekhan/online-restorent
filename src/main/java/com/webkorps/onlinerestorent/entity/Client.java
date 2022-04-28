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
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Membership membership;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Restro restro;
	
}
