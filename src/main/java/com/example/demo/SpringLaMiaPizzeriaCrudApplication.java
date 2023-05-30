package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}
	
	@Autowired
	private PizzaService pizzaService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Pizza pizza1 = new Pizza("Margherita", "Pomodoro, mozzarella", "https://cdn.shopify.com/s/files/1/0586/6795/8427/articles/Margherita-9920.jpg?crop=center&height=915&v=1644590028&width=1200", 6);
		Pizza pizza2 = new Pizza("Napoli", "Pomodoro, mozzarella, acciughe", "https://cdn.shopify.com/s/files/1/0586/6795/8427/articles/Margherita-9920.jpg?crop=center&height=915&v=1644590028&width=1200", 8);
		Pizza pizza3 = new Pizza("Marinara", "Pomodoro, origano", "https://cdn.shopify.com/s/files/1/0586/6795/8427/articles/Margherita-9920.jpg?crop=center&height=915&v=1644590028&width=1200", 5);
		
		pizzaService.save(pizza1);
		pizzaService.save(pizza2);
		pizzaService.save(pizza3);
	}

}
