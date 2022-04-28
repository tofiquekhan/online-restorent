package com.webkorps.onlinerestorent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webkorps.onlinerestorent.entity.Dish;
import com.webkorps.onlinerestorent.entity.Restro;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
	
	List<Dish> findAllByRestro(Restro restro); 

}
