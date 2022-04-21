package com.webkorps.onlinerestorent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webkorps.onlinerestorent.entity.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

}
