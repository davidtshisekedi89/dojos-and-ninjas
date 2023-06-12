package com.david.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.david.dojosandninjas.models.Dojo;
import com.david.dojosandninjas.models.Ninja;
import com.david.dojosandninjas.services.DojoService;
import com.david.dojosandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	// Render Dojo
	@GetMapping("/dojos/new")
	public String renderCreateDojoForm(@ModelAttribute("newDojo")Dojo newDojo) {
		return "dojos.jsp";
	}
	
	
	@PostMapping("/dojos/new")
	public String processDojo(
			@Valid @ModelAttribute("newDojo")Dojo newDojo, BindingResult result
			) {
		if(result.hasErrors()) {
			return "dojos.jsp";
			
		} else {
			dojoService.createDojo(newDojo);
			return "redirect:/dojos";
		}
	}
	
	
	
	// Render Ninja
	@GetMapping("/ninjas/new")
	public String renderCreateNinjaForm(Model model) {
		model.addAttribute("newNinja", new Ninja());
		model.addAttribute("dojoList", dojoService.allDojos());
		
		return "ninjas.jsp";
	}
	
	
	@PostMapping("/ninjas/new")
	public String processNinja(
			@Valid @ModelAttribute("newNinja")Ninja newNinja,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojoList", dojoService.allDojos());
			return "ninjas.jsp";
			
		}else {
			ninjaService.createNinja(newNinja);
			return "redirect:/ninjas";
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String dashboard(@PathVariable("id")Long id,Model model) {
//		model.addAttribute("ninjaList", ninjaService.allNinjas());
		Dojo oneDojo = dojoService.findDojo(id);
		model.addAttribute("oneDojo", oneDojo);
		return "dashboard.jsp";
	}


}
