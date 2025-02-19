package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue
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
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal=sal;
	}
	public String toString() {
		return "Product[id:"+id+", name:"+name+", sal:"+sal+"]";
	}
}
