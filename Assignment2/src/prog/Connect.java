package prog;

import java.sql.*;
import java.util.Scanner;

public class Connect 
{
	final static String url = "jdbc:mysql://localhost:3306/core";
	final static String user = "root";
	final static String pass = "root";

static Connection connectify() throws Exception
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection join = DriverManager.getConnection(url, user, pass);
	return join;	
}

public static void conn() throws Exception
{
	try 
		{
		Connection join = connectify();
			if(join==null)
			{
				System.out.println("Connection failed to establish");
			}
			
		} 
	catch (SQLException se)
	{
		se.printStackTrace();
	}
}

	/*
	 * public static void main(String[] args) { try { conn(); } catch (Exception e)
	 * { e.printStackTrace(); } }
	 */

}
