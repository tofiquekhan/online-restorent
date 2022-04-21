package com.webkorps.onlinerestorent.dto;

import lombok.Data;

@Data
public class DishDto {
	private Long id;
	private String name;
	private float price;
	private String image;
}
