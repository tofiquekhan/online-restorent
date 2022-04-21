package com.webkorps.onlinerestorent.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "payment")
@Data
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "amount")
	private float amount;
	
	@Column(name = "transaction_id")
	private int transactionId;
	
	@Column(name = "tx_time")
	private LocalDateTime txTime;
	
	@OneToOne
	private Client client;
}
