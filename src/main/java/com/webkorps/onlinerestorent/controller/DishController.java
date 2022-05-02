package com.webkorps.onlinerestorent.controller;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String addDishPage() {
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
	public String addDish(HttpSession session, Model model,@RequestParam(name = "dishName") String dishName,@RequestParam(name = "dishPrice") String dishPrice,@RequestParam(name = "dishImage") MultipartFile dishImage) {
		String msg = "fail";
		try {
		Client client= (Client) session.getAttribute("client");
		Restro restro = client.getRestro();
		if(restro==null) {
			System.out.println("Restro COntroller if for restro null");
			msg = "restro";
			model.addAttribute("msg1", msg);
			return "addDish";
		}
		Dish dish = new Dish();
		if(!dishImage.isEmpty()) {
		
			File file = new ClassPathResource("static\\img").getFile();
			String imageName = dishImage.getOriginalFilename()+LocalDate.now().toString();
			Path path = Paths.get(file.getAbsolutePath()+File.separator+imageName);
			Files.copy(dishImage.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			dish.setImage(imageName);
			System.out.println("Image Upload Successfully");
		}
		
		dish.setName(dishName);
		dish.setPrice(Integer.parseInt(dishPrice));
		dish.setRestro(restro);
		Dish savedDish = dishService.addDish(dish);
		if(savedDish.getId()>0) {
			msg = "success";
		}
		model.addAttribute("msg", msg);
	}catch (Exception e) {
		e.printStackTrace();
	}
		return "addDish";
	}
}
