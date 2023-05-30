package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "Il nome non può essere vuoto")
	private String name;
	@NotBlank(message = "La descrizione non può essere vuota")
	private String description;
	@NotBlank(message = "Per favore inserire una foto")
	private String imgUrl;

	@DecimalMin(value = "0.01", message = "Il prezzo deve essere maggiore di 0")
	private double price;
	
	public Pizza() { }
	public Pizza (String name, String description, String imgUrl, double price) {
		
		setName(name);
		setDescription(description);
		setImgUrl(imgUrl);
		setPrice(price);
	}
	
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] " + getName();
	}
	
}