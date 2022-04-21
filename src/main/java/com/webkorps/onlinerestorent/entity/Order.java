package com.webkorps.onlinerestorent.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "order")
@Data
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "total_amount")
	private float totalAmount;
	
	@Column(name = "payment_status")
	private String paymentStatus;
	
	@OneToOne
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Dish> dishes;
	
	@OneToOne
	private Payment payment;
	
	
}
