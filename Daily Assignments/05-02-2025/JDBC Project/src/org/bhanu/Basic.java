package org.bhanu;
import java.sql.*;
public class Basic {
	public static void main(String arg[]) throws SQLException,Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techm?autoReconnect=true&useSSL=false","root","Vbhanu@2003");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select *from emp");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		}
	}
}
