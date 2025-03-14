package com.examples.generic;

public class GenericEx1<T> {
    private T[] a;
    private T[] b;

    // Constructor to initialize arrays
    public GenericEx1(T[] x, T[] y) {
        this.a = x;
        this.b = y;
    }
    public boolean compare() {
    	if(a.length==b.length) {
    		for(int i=0;i<a.length;i++) {
    			if(a[i]!=b[i]) {
    				return false;
    			}
    		}
    		return true;
    	}
    	return false;
    }
}
