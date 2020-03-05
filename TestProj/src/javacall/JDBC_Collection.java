package javacall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Iterator;

public class JDBC_Collection {
	final static String url = "jdbc:mysql://localhost/docker";
	final static String username = "root";
	final static String password = "root";
	final static String select = "select * from dock";
	//private static final Connection null = null;

	static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
		
	}
	/*
	 * public Iterator<> iterator() { // TODO Auto-generated method stub return
	 * null; }
	 */
}
