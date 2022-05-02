package com.webkorps.onlinerestorent.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.webkorps.onlinerestorent.entity.Dish;
import com.webkorps.onlinerestorent.service.DishService;

@Controller
public class OrderController {

	@Autowired
	private DishService dishService;
	
	@GetMapping("/client/restro/order")
	public String viewOrderPage() {
		return "viewOrders";
	}
	
	@GetMapping("/user/myorder")
	public String userMyOrderPage() {
		return "userMyOrder";
	}
	
	@GetMapping("/user/dish/{restroId}/addToCart/{dishId}")
	public ModelAndView addToCart(Model model,HttpSession session,@PathVariable(name = "dishId")Long dishId,@PathVariable(name = "restroId")Long restroId) {
		Dish dish = dishService.getDishById(dishId);
		Map<Dish,Integer> cart = null;
		float  totalAmount = 0;
		if (session.getAttribute("cart") == null) {
			cart = new HashMap<Dish,Integer>();
			cart.put(dish, 1);
		} else {
			cart = (Map<Dish,Integer>) session.getAttribute("cart");
			Boolean flag = cart.containsKey(dish);
			if (flag) {
				cart.put(dish, 1);
			} else {
				int quantity = cart.get(dish) + 1;
				cart.put(dish, quantity);
			}
		}
		totalAmount=totalAmount+dish.getPrice();
		session.setAttribute("totalAmount", totalAmount);
		session.setAttribute("cart", cart);
		System.out.println("cart print "+cart);
		return new ModelAndView("redirect:"+"/user/restro/menu/"+restroId);
	}
	
	
}
