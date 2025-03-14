package org.bhanu;
import java.sql.*;
import java.util.*;
public class Insertion {
	public static void main(String arg[]) throws SQLException,ClassNotFoundException,Exception{
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/techm?autoReconnect=true&useSSL=false","root","Vbhanu@2003");
		PreparedStatement ps=con.prepareStatement("insert into emp values(?,?,?)");
		System.out.print("Enter no of insertionms to be done:");
		int x=sc.nextInt();
		int c=0;
		for(int i=0;i<x;i++) {
			System.out.print("Enter Employee ID:");
			ps.setInt(1,sc.nextInt());
			System.out.print("Enter Employee Name: ");
			ps.setString(2, sc.next());
			System.out.println("Enter Department ID: ");
			ps.setInt(3,sc.nextInt());
			c+=ps.executeUpdate();
		}
		System.out.println(c+" rows executed");
		ps.close();
		con.close();
	}
}
