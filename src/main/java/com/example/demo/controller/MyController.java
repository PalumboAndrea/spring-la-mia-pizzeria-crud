package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Pizza;
import com.example.demo.PizzaService;

@Controller
public class MyController {

	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/home")
	public String homeView(Model model) {
	
		List<Pizza> pizze = pizzaService.findAll();
		
		model.addAttribute("pizze", pizze);
		
		return "index";
	}
	
	@GetMapping("/pizze/{id}")
	public String showView(Model model,
			@PathVariable("id") int id) {
	
		Optional<Pizza> optPizza = pizzaService.findById(id);
		Pizza pizza = optPizza.get();
		
		model.addAttribute("pizza", pizza);
		
		return "show";
	}
	
	@PostMapping("/pizze/by/name")
	public String search(Model model,
			@RequestParam(required = false) String name) {
	
		List<Pizza> pizze = pizzaService.findByName(name);
		
		model.addAttribute("pizze", pizze);
		model.addAttribute("name", name);
		
		return "search";
	}
	
	@GetMapping("/pizze/create")
	public String createPizza() {
		
		return "create";
	}
	
	@PostMapping("/pizze/create")
	public String storePizzs(@ModelAttribute Pizza pizza) {
		
		pizzaService.save(pizza);
		
		return "redirect:/home";
	}
	
	
}
