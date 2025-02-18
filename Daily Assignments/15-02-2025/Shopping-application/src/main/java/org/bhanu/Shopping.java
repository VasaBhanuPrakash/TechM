package org.bhanu;

public class Shopping {
	private String name;
	private float cost;
	private Payment p;
	public void setName(String name) {
		this.name=name;
	}
	public void setCost(float cost) {
		this.cost=cost;
	}
	public void setPayment(Payment p) {
		this.p=p;
	}
	public void display() {
		System.out.println("Purchasing Item name: "+name);
		System.out.println("Cost of Item: "+cost);
		p.displayPayment(cost);
	}
}
