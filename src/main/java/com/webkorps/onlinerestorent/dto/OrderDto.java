package com.webkorps.onlinerestorent.dto;

import java.util.Set;

import lombok.Data;

@Data
public class OrderDto {
	
	private Long id;
	private float totalAmount;
	private String paymentStatus;
	private UserDto userDto;
	private Set<DishDto> dishDtos;
	private PaymentDto paymentDto;

}
