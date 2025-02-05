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
		int value=sc.nextInt();		
		int pos=sc.nextInt();
		l.add(pos,value);
		System.out.println("Linked list after entering element: "+l);
		sc.close();
	}
}
