package com.example.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document
public class Product {
	@Id
	private Integer id;
	private String name;
	private int sal;
	public Product() {
		super();
	}
	public Product(Integer id) {
		super();
		this.id=id;
	}
	public Product(String name,int sal) {
		this.name=name;
		this.sal=sal;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int setSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal=sal;
	}
	public String toString() {
		return "Product[ID:"+id+", Name:"+name+", Salary:"+sal+"]";
	}
}
