package org.bhanu;

public class Calculator {
	public int sum(int a,int b) {
		return a+b;
	}
	public int diff(int a,int b) {
		return a-b;
	}
	public int product(int a,int b) {
		return a*b;
	}
	public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}
