package com.examples.gen;
import com.examples.generic.*;
public class SameArray {
	public static void main(String arg[]) {
		Integer[] a= {6,8,3};
		Integer[] b= {6,7,5,3};
		GenericEx1<Integer> g=new GenericEx1<>(a,b);
		if(g.compare()) {
			System.out.print("Arrays are matched");
		}
		else {
			System.out.println("Arrays are mismatched");
		}
	}
}
