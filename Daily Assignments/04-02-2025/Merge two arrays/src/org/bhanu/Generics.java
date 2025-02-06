package org.bhanu;
import java.lang.Math;
public class Generics<T> {
	private T[] a;
	private T[] b;
	private T[] c;
	public Generics(T[] a,T[] b,T[] c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
	int j=0;
	int i;
	public void merge() {
		for(i=0;i<Math.min(a.length, b.length);i++) {
			c[j]=a[i];
			c[j+1]=b[i];
			j+=2;
		}
		if(a.length>b.length) {
			for(i=b.length;i<a.length;i++) {
				c[j]=a[i];
				j++;
			}
		}
		else {
			for(i=a.length;i<b.length;i++) {
				c[j]=b[i];
				j++;
			}
		}
		for(i=0;i<c.length;i++) {
			System.out.println(c[i]);
		}
	}
}
