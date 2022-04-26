package com.webkorps.onlinerestorent.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webkorps.onlinerestorent.dto.DishDto;
import com.webkorps.onlinerestorent.entity.Dish;
import com.webkorps.onlinerestorent.repository.DishRepository;
import com.webkorps.onlinerestorent.service.DishService;

@Service
public class DishServiceImpl implements DishService{

	@Autowired
	private DishRepository dishRepository;
	
	@Autowired
	private ModelMapper modelMapper ;
	
	@Override
	public DishDto addDish(DishDto dishDto) {
		Dish dish = modelMapper.map(dishDto, Dish.class);
		Dish savedDish = dishRepository.save(dish);
		DishDto savedDishDto = modelMapper.map(savedDish, DishDto.class);
		return savedDishDto;
	}

}
