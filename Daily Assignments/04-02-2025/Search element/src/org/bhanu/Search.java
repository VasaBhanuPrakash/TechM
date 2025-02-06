package org.bhanu;
import java.util.*;
public class Search {
public static void main(String arg[]) {
	ArrayList<Integer> l=new ArrayList<>();
	Scanner sc=new Scanner(System.in);
	l.add(6);
	l.add(56);
	l.add(85);
	l.add(85);
	l.add(86);
	l.add(84);
	int x=sc.nextInt();
	boolean b=false;
	for(int i=0;i<l.size();i++) {
		if (l.get(i)==x) {
			System.out.println("Element is found at index:"+i);
			b=true;
			break;
		}
	}
	if(b==false) {
		System.out.println("Element not found");
	}
	sc.close();
}
}
