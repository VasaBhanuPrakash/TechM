package org.bhanu;
import java.util.*;
public class Insert {
	public static void main(String arg[]) {
		Scanner sc=new Scanner(System.in);
		LinkedList<Integer> l=new LinkedList<>();
		l.add(5);
		l.add(76);
		l.add(83);
		l.add(75);
		System.out.println("Linked List before add element: "+l);
		int x=sc.nextInt();
		l.addFirst(x);
		System.out.println("LinkedListed after adding "+x+" at the start: "+l);
		sc.close();
	}
}
