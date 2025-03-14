package org.bhanu;
import static java.lang.Integer.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
public class Marks {
	public static void main(String arg[]) {
		String arr[][]=new String[8][7];
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<arr.length;i++) {
			System.out.print("Enter Student name:");
			arr[i][0]=sc.next();
			System.out.print("Enter "+arr[i][0]+"'s Maths marks:");
			arr[i][1]=sc.next();
			System.out.print("Enter "+arr[i][0]+"'s Python marks:");
			arr[i][2]=sc.next();
			System.out.print("Enter "+arr[i][0]+"'s Java marks:");
			arr[i][3]=sc.next();
			System.out.print("Enter "+arr[i][0]+"'s HTML marks:");
			arr[i][4]=sc.next();
			arr[i][5]=Integer.toString(parseInt(arr[i][1])+parseInt(arr[i][2])+parseInt(arr[i][3])+parseInt(arr[i][4]));
			arr[i][6]=Integer.toString(parseInt(arr[i][5])/4);
		}
		Arrays.sort(arr,new Comparator<String[]>() {
			public int compare(String[] a,String[] b){
				return Integer.compare(parseInt(b[6]),parseInt(a[6]));
			}
		});
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i][0]+" "+arr[i][1]+" "+arr[i][2]+" "+arr[i][3]+" "+arr[i][4]+" "+arr[i][5]+" ");
			System.out.println(arr[i][6]);
		}
		sc.close();
	}
}
