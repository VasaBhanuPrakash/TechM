package org.sum.generic; 
public class GenericSum<T extends Number> {
	private T[] a;
	public GenericSum(T[] array) {
		this.a=array;
	}
	public void sum() {
		int e=0;
		int o=0;
		for(T i:a) {
			int num=i.intValue();
			if((num%2)==0) {
				e+=num;
			}
			else {
				o+=num;
			}
		}
		System.out.println("Sum of Even numbers is: "+e);
		System.out.println("Sum of Odd numbers is: "+o);
	}
}
