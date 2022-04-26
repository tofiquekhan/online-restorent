package com.webkorps.onlinerestorent.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.webkorps.onlinerestorent.dto.RestroDto;
import com.webkorps.onlinerestorent.service.RestroService;

@RestController
@RequestMapping("/client/restro")
public class RestroController {
	
	@Autowired
	private RestroService restroService;

	@GetMapping
	public ModelAndView addRestroPage() {
		
		return new ModelAndView("addRestro");
	}
	
	
	@PostMapping
	public ModelAndView addRestro(Model model, @RequestParam(name = "name") String	name) {
		RestroDto restroDto = new RestroDto();
		restroDto.setName(name);
		restroService.addRestro(restroDto);
		model.addAttribute("name", name);
		return new ModelAndView("addRestro");
	}
	
	
}
