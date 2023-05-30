package com.example.demo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

	@Autowired
	private PizzaRepository pizzaRepository;
	
	public List<Pizza> findAll() {
		
		return pizzaRepository.findAll();
	}
	public Pizza save(Pizza pizza) {
		
		return pizzaRepository.save(pizza);
	}
	public Optional<Pizza> findById(int id) {
		
		return pizzaRepository.findById(id);
	}
	
	public List<Pizza> findByName(String name) {
		
		return pizzaRepository.findByNameContaining(name);
	}
	
	public void deleteBook(Pizza pizza) {
		
		pizzaRepository.delete(pizza);
	}
}
