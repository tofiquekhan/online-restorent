package com.webkorps.onlinerestorent.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.webkorps.onlinerestorent.entity.Client;
import com.webkorps.onlinerestorent.entity.Dish;
import com.webkorps.onlinerestorent.entity.Restro;
import com.webkorps.onlinerestorent.repository.RestroRepository;
import com.webkorps.onlinerestorent.service.ClientService;
import com.webkorps.onlinerestorent.service.DishService;
import com.webkorps.onlinerestorent.service.RestroService;

@Controller
public class RestroController {
	
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private RestroService restroService;
	
	@Autowired
	private DishService dishService;
	

	@GetMapping("/client/restro")
	public ModelAndView addRestroPage(HttpSession session) {
		return new ModelAndView("addRestro");
	}
	
	
	@PostMapping("/client/restro")
	public ModelAndView addRestro(Model model,HttpSession session, @RequestParam(name = "name") String	name) {
		
		
		Client client = (Client)session.getAttribute("client");
		
		Restro restro = new Restro();
		
		
		restro.setName(name);
		client.setRestro(restro);
		clientService.addClient(client);
		session.setAttribute("client", client);
		model.addAttribute("name", name);
		return new ModelAndView("addRestro");
	}
	
	@PostMapping("/user/restro/search")
	public String searchRestro(Model model,@RequestParam(name = "restroName") String restroName) {
		System.out.println("Restro Name is Search "+restroName);
		List<Restro> searchedRestro = restroService.getRestrosByName(restroName);
		model.addAttribute("restros", searchedRestro);
		
		return "userHome";
	}
	
	@GetMapping("/user/restro/menu/{id}")
	public String restroMenu(@PathVariable(name = "id") Long id,Model model) {
		Restro restro = restroService.getRestroById(id);
		List<Dish> dishes = dishService.getAllDishesByRestro(restro);
		model.addAttribute("dishes", dishes);
		model.addAttribute("restro", restro);
		return "restroMenu";
	}
	
}
