package com.webkorps.onlinerestorent.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webkorps.onlinerestorent.entity.Client;
import com.webkorps.onlinerestorent.entity.Dish;
import com.webkorps.onlinerestorent.entity.Restro;
import com.webkorps.onlinerestorent.service.DishService;

@Controller
@RequestMapping("/client/restro/dish")
public class DishController {

	@Autowired
	private DishService dishService;
	
	@GetMapping
	public String addDishPage(HttpSession session,ModelMap model) {
		return "addDish";
	}
	
	
	@GetMapping("/dishes")
	public String dishesPage(HttpSession session,ModelMap model) {
		Client client = (Client) session.getAttribute("client");
		Restro restro = client.getRestro();
		List<Dish> dishes = dishService.getAllDishesByRestro(restro);
		model.addAttribute("restro", dishes);
		return "dishes";
	}
	
	
	@PostMapping
	public String addDish(HttpSession session, Model model,@RequestParam(name = "dishName") String dishName,@RequestParam(name = "dishPrice") String dishPrice) {
		Client client= (Client) session.getAttribute("client");
		Restro restro = client.getRestro();
		
		Dish dish = new Dish();
		dish.setName(dishName);
		dish.setPrice(Integer.parseInt(dishPrice));
		dish.setRestro(restro);
		Dish savedDish = dishService.addDish(dish);
		String msg = "fail";
		if(savedDish.getId()>0) {
			msg = "success";
		}
		model.addAttribute("msg", msg);
		return "addDish";
	}
}
