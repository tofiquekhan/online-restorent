package com.webkorps.onlinerestorent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webkorps.onlinerestorent.entity.Dish;
import com.webkorps.onlinerestorent.entity.Restro;
import com.webkorps.onlinerestorent.repository.DishRepository;
import com.webkorps.onlinerestorent.service.DishService;

@Service
public class DishServiceImpl implements DishService{

	@Autowired
	private DishRepository dishRepository;
	
	
	public List<Dish> getAllDishesByRestro(Restro restro){
		List<Dish> dishs = dishRepository.findAllByRestro(restro);
		return dishs;
	}
	
	@Override
	public Dish addDish(Dish dish) {
		Dish savedDish = dishRepository.save(dish);
		return savedDish;
	}

	@Override
	public Dish getDishById(Long id) {
		return dishRepository.getById(id);
	}
	
}
