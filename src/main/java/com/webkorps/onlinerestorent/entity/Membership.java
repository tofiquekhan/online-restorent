package com.webkorps.onlinerestorent.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "membership")
@Data
public class Membership {
	
	int plan1 = 30;
	int plan2 = 60;
	int plan3 = 90;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",length = 10)
	private Long id;
	
	@Column(name = "purchase_date")
	private LocalDate purchaseDate;
	
	@Column(name = "expire_date")
	private LocalDate expireDate;
	
	@Column(name = "price")
	private float price;

	@OneToOne
	private Payment payment;
}
