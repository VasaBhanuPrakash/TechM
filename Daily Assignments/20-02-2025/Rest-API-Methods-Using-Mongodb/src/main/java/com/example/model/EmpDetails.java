package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;
@Document
public class EmpDetails {
	@Id
	private Long id;
	private String name;
	private double sal;
	public EmpDetails() {
		super();
	}
	public EmpDetails(Long id) {
		this.id=id;
	}
	public EmpDetails(String name,double sal) {
		this.name=name;
		this.sal=sal;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal=sal;
	}
	public String toString() {
		return "Employee[id:"+id+", name:"+name+", sal:"+sal+"]";
	}
}
