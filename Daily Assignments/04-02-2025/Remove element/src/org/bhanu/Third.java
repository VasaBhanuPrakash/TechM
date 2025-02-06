package org.bhanu;
import java.util.*;
public class Third {
	public static void main(String arg[]) {
		ArrayList<Integer> l=new ArrayList<>();
		l.add(56);
		l.add(6);
		l.add(978);
		l.add(65);
		l.add(74);
		l.add(73);
		l.add(72);
		System.out.println("l before removing third element"+l);
		l.remove(3);
		System.out.println("l after removing third element"+l);	
	}
}
