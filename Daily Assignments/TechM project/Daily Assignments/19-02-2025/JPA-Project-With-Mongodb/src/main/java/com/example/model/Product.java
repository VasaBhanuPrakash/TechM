package com.example.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection="food")
public class Product {
	@Id
	private String id;
	private String name;
	private double price;
	public Product() {
		super();
	}
	public Product(String name,double price) {
		this.name=name;
		this.price=price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	public String toString() {
		return "Product[ID:"+id+", Name:"+name+", Price:"+price+"]";
	}
}
