package com.webkorps.onlinerestorent.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.webkorps.onlinerestorent.entity.Client;
import com.webkorps.onlinerestorent.entity.Restro;
import com.webkorps.onlinerestorent.entity.RestroUserDetail;
import com.webkorps.onlinerestorent.entity.User;
import com.webkorps.onlinerestorent.service.ClientService;
import com.webkorps.onlinerestorent.service.RestroService;
import com.webkorps.onlinerestorent.service.UserService;

@RestController
@RequestMapping("/client/restro")
public class RestroController {
	
	@Autowired
	private RestroService restroService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private UserService userService;
	
	

	@GetMapping
	public ModelAndView addRestroPage(HttpSession session) {
		return new ModelAndView("addRestro");
	}
	
	
	@PostMapping
	public ModelAndView addRestro(Model model,HttpSession session, @RequestParam(name = "name") String	name) {
		
		
		Client client = (Client)session.getAttribute("client");
		
		Restro restro = new Restro();
		
		Enumeration<String> es = session.getAttributeNames();
		while(es.hasMoreElements()) {
			System.out.println(es.nextElement());
		}
		
		restro.setName(name);
		client.setRestro(restro);
		System.out.println(" client dto user dto id"+client.getUser().getId());
		clientService.addClient(client);
		model.addAttribute("name", name);
		return new ModelAndView("addRestro");
	}
	
	
}
