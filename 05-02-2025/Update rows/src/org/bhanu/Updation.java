package org.bhanu;
import java.sql.*;
import java.util.*;
public class Updation {
	public static void main(String arg[]) throws SQLException, Exception{
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techm?autoReconnect=true&useSSL=false","root","Vbhanu@2003");
		PreparedStatement ps=con.prepareStatement("Update emp set ename=? where empid=?");
		System.out.println("Enter Employee ID");
		ps.setString(1, sc.next());
		ps.setInt(2, sc.nextInt());
		int val=ps.executeUpdate();
		System.out.println(val+" Rows updated");
		ps.close();
		con.close();
		sc.close();
	}
}
