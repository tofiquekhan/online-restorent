package com.webkorps.onlinerestorent.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.webkorps.onlinerestorent.entity.Client;
import com.webkorps.onlinerestorent.service.ClientService;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/admin/clients")
	public String allClientsPage(HttpSession session,ModelMap model) {
		List<Client> clients = clientService.getAllClients();
		model.addAttribute("clients", clients);
		return "allClients";
	}
	

}
