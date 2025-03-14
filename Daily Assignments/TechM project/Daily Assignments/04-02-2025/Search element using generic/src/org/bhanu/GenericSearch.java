package org.bhanu;

public class GenericSearch<T> {
	private T[] a;
	private T tar;
	public GenericSearch(T[] a,T tar) {
		this.a=a;
		this.tar=tar;
	}
	public int searchElement() {
		for(int i=0;i<a.length;i++) {
			if(a[i]==tar) {
				return i;
			}
		}
		return -1;
	}
}
