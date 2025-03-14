package org.bhanu;
import java.util.*;
public class Iteratre {
	public static void main(String arg[]) {
		Scanner sc=new Scanner(System.in);
		LinkedList<Integer> l=new LinkedList<>();
		l.add(5);
		l.add(76);
		l.add(83);
		l.add(75);
		int x=sc.nextInt();
		ArrayList<Integer> a=new ArrayList<>();
		Iterator<Integer> i=l.iterator();
		while(i.hasNext()) {
			a.add(i.next());
			x--;
			if(x<=0) {
				break;
			}
		}
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		for(int j:a) {
			System.out.println(j);
		}
		sc.close();
	}
}
