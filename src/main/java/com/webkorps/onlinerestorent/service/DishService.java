package com.webkorps.onlinerestorent.service;

import java.util.List;

import com.webkorps.onlinerestorent.entity.Dish;
import com.webkorps.onlinerestorent.entity.Restro;

public interface DishService {

	Dish addDish(Dish dish);
	
	List<Dish> getAllDishesByRestro(Restro restro);
}
