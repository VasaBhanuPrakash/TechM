package org.bhanu;
import java.util.*;
public class Iterate {
	public static void main(String arg[]) {
		LinkedList<Integer> l=new LinkedList<>();
		l.add(5);
		l.add(76);
		l.add(83);
		l.add(75);
		for(int i:l) {
			System.out.println(i);
		}
	}
}
