package org.bhanu;

public class Search {
	public static void main(String arg[]) {
	Integer[] a= {5,7,6,3,2,8,6,4,9};
	Integer tar=4;
	GenericSearch<Integer> g=new GenericSearch<>(a,tar);
	System.out.println(g.searchElement());
	}
}
