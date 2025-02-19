package org.bhanu;

public class Empdetails {
	private int id;
	private String name;
	private String city;
	public void setId(int id) {
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setCity(String city) {
		this.city=city;
	}
	public String getCity() {
		return city;
	}
	public void display() {
		System.out.println(id+" "+name+" "+city);
	}
}
