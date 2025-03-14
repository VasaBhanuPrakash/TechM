package org.bhanu;

public class MergeArray {
	public static  void main(String arg[]) {
	Integer[] a= {6,7,4,8,9,7,8};
	Integer b[]= {8,7,8,9,3};
	Integer c[]=new Integer[a.length+b.length];
	Generics<Integer> g=new Generics<>(a,b,c);
	g.merge();
}
}
