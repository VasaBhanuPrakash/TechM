package org.bhanu;

public class ItemDetails {
	private String name;
	private float cost;
	private int count;
	public void setName(String name) {
		this.name=name;
	}
	public void setCost(float cost) {
		this.cost=cost;
	}
	public void setCount(int count) {
		this.count=count;
	}
	public void display() {
		System.out.println("Item name: "+name);
		System.out.println("Cost per unit : "+cost);
		System.out.println("Count of "+name+" : "+count);
		System.out.println("Cost: "+(cost*count));
	}
}
