package org.bhanu;
import java.util.ArrayList;
public class Iterate {
	public static void main(String arg[]) {
		ArrayList<Integer> l=new ArrayList<>();
		l.add(3);
		l.add(5);
		l.add(1);
		l.add(6);
		for(int i:l) {
			System.out.println(i);
		}
	}
}
