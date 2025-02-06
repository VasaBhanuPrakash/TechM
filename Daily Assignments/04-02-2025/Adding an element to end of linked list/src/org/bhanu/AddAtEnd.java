package org.bhanu;
import java.util.LinkedList;
public class AddAtEnd {
	public static void main(String arg[]) { 
		LinkedList<Integer> l=new LinkedList<>();
		l.add(5);
		l.add(76);
		l.add(83);
		l.add(75);
		System.out.println("Linked list: "+l);
		l.addLast(87);
		System.out.print("Linked list:"+l);
	}
}
