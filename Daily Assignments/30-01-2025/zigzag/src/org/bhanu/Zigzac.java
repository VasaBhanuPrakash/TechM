package org.bhanu;
import static java.util.Arrays.*;

public class Zigzac {
	public static void main(String arg[]) {
		int arr1[]= {4,6,7};
		int arr2[]=new int[((arr1.length)/2)+1];
		for(int i=0;i<arr2.length;i++) {
			arr2[i]=copyOfRange(arr1,i*2,(i*2)+1)[0];
			System.out.print(arr2[i]+" ");
		}
		System.out.println();
		for(int i=0;i<(arr1.length+1)/2;i++) {
			arr1[i]=copyOfRange(arr1,i*2,i*2+1)[0];
			System.out.print(arr1[i]+" ");
		}
	}
}