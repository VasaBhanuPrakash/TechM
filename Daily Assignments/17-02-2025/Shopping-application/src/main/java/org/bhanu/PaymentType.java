package org.bhanu;

public class PaymentType implements Payment{
	private String paymentType;
	public void setPaymentType(String paymentType) {
		this.paymentType=paymentType;
	}
	
	public void displayPayment(float cost) {
		System.out.println("Payment of \u20B9"+cost+" processed via "+paymentType);
		System.out.println("Order is placed successfully");
	}
}
