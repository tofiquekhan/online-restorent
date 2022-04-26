package com.webkorps.onlinerestorent.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "restro")
@Data
public class Restro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",length = 10)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Dish> menu;
	
	@Column(name = "created_date")
	private LocalDate createdDate;
	
	@Column(name = "modified_by")
	private String modifiedBy;
	
	@Column(name = "modified_date")
	private LocalDate modifiedDate;
}
