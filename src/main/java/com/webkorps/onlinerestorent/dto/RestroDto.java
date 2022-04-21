package com.webkorps.onlinerestorent.dto;

import java.time.LocalDate;
import java.util.Set;

import lombok.Data;

@Data
public class RestroDto {

	private Long id;
	private String name;
	private Set<DishDto> menu;
	private LocalDate createdDate;
	private String modifiedBy;
	private LocalDate modifiedDate;
}
