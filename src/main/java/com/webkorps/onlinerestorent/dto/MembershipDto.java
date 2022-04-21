package com.webkorps.onlinerestorent.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MembershipDto {

	private Long id;
	private LocalDate purchaseDate;
	private LocalDate expireDate;
	private float price;
	private PaymentDto paymentDto;
}
