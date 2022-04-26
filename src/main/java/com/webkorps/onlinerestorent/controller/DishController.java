package com.webkorps.onlinerestorent.controller;

import javax.websocket.server.PathParam;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webkorps.onlinerestorent.dto.DishDto;
import com.webkorps.onlinerestorent.service.DishService;

@Controller
@RequestMapping("/client/restro/dish")
public class DishController {

	@Autowired
	private DishService dishService;
	
	@GetMapping
	public String addDishPage() {
		return "addDish";
	}
	
	@PostMapping
	public String addDish(Model model,@RequestParam(name = "dishName") String dishName,@RequestParam(name = "dishPrice") String dishPrice) {
		DishDto dishDto = new DishDto();
		dishDto.setName(dishName);
		dishDto.setPrice(Integer.parseInt(dishPrice));
		DishDto savedDishDto =  dishService.addDish(dishDto);
		if(savedDishDto.getId()>0) {
			model.addAttribute("msg", "Success");
		}else {
			model.addAttribute("msg", "Failure");
		}
		return "addDish";
	}
}
