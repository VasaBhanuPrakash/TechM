package org.bhanu;
import java.util.*;
public class Sorting {
	public static void main(String arg[]) {
		ArrayList<Integer> l=new ArrayList<>();
		l.add(56);
		l.add(6);
		l.add(978);
		l.add(65);
		l.add(74);
		l.add(73);
		l.add(72);
		System.out.println("l before sorting|:"+l);
		Collections.sort(l);
		System.out.println("l after sorting:"+l);
		ArrayList<String> colors=new ArrayList<>();
		colors.add("red");
		colors.add("yellow");
		colors.add("green");
		colors.add("orange");
		System.out.println("Colors before sorting:"+colors);
		colors.sort((a,b)->a.compareTo(b));
		System.out.print("Colors after sorting:"+colors);
	}
}
