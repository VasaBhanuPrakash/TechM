package org.bhanu;
import java.util.*;
import java.sql.*;
public class Deletion {
	public static void main(String arg[]) throws SQLException, Exception{
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techm?autoReconnect=true&useSSL=false","root","Vbhanu@2003");
		PreparedStatement ps=con.prepareStatement("delete from emp where empid=?");
		System.out.println("Enter Employee ID of employee whose data is going to be deleted");
		ps.setInt(1, sc.nextInt());
		int val=ps.executeUpdate();
		System.out.print(val+" Rows are deleted");
		ps.close();
		con.close();
		sc.close();
	}
}
