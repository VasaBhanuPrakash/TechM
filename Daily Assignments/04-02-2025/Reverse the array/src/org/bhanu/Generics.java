package org.bhanu;

public class Generics<T> {
	T[] a;
	public Generics(T[] a) {
		this.a=a;
	}
	T temp;
	public void reverse() {
		for(int i=0;i<(a.length+1)/2;i++) {
			temp=a[i];
			a[i]=a[a.length-i-1];
			a[a.length-i-1]=temp;
		}
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
	}
}
