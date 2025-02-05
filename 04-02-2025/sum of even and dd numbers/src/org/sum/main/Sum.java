package org.sum.main;
import org.sum.generic.*;
public class Sum {
	public static void main(String arg[]) {
	Integer[] a= {4,65,7};
	GenericSum<Integer> g=new GenericSum<>(a);
	g.sum();
	}
}

