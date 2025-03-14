package org.bhanu;
import java.util.*;
public class ArrayUpdate {
	public static void main(String arg[]) {
		ArrayList<Integer> l=new ArrayList<>();
		l.add(6);
		l.add(76);
		l.add(834);
		l.add(68);
		l.add(57);
		System.out.println("l before updated:"+l);
		l.set(2,96);
		System.out.println("l after updated:"+l);
	}
}
