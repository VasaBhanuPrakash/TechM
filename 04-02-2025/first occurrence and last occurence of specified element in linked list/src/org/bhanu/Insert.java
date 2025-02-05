package org.bhanu;
import java.util.*;
public class Insert{
	public static void main(String arg[]) {
		Scanner sc=new Scanner(System.in);
		LinkedList<Integer> l=new LinkedList<>();
		l.add(5);
		l.add(76);
		l.add(83);
		l.add(75);
		l.add(65);
		l.add(68);
		l.add(75);
		l.add(73);
		System.out.println("Enter the number to be searched");
		int x=sc.nextInt();
		Iterator<Integer> l1=l.iterator();
		int i=1;
		int j=1;
		int z=0;
		while(l1.hasNext()) {
			if(l1.next()==x) {
				break;
			}
			else{
				i++;
			}
		}
		System.out.println("First occurence of the element "+x+" is: "+i);
		Iterator<Integer> l2=l.iterator();
		while(l2.hasNext()) {
			if(l2.next()==x) {
				z=j;
			}
			j++;
		}
		System.out.println("Last occurence of the element "+x+" is: "+z);
		sc.close();
	}
}
