package com.webkorps.onlinerestorent.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PaymentDto {

	private Long id;
	private float amount;
	private int transactionId;
	private LocalDateTime txTime;
	private ClientDto clientDto;
}
