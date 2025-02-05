package org.bhanu;
import java.util.*;
public class Copy {
public static void mnain(String arg[]) {
	ArrayList<Integer> l=new ArrayList<>();
	l.add(6);
	l.add(76);
	l.add(834);
	l.add(68);
	l.add(57);
	ArrayList<Integer> l1=new ArrayList<>(l);
	System.out.println("Orginial List: "+l);
	System.out.println("Copied list1: "+l1);
}
}
