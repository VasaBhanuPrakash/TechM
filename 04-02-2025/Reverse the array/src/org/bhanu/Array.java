package org.bhanu;
public class Array {
	public static void main(String arg[]) {
	Integer[] a= {8,7,9,6};
	Generics<Integer> g=new Generics<>(a);
	g.reverse();
	}
}
