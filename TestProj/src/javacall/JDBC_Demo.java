package javacall;
import java.sql.*;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;
import java.io.Console;

public class JDBC_Demo {
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
	
	private static void updateRecord(int id,String name,int price) throws Exception
	{
		String query = "update dock set name=?,price=? where id =?";
		try
		{
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, price);
		}
		catch (SQLException se) 
		{
			se.getMessage();
		}
		catch (Exception e) 
		{
			e.getMessage();
		}
	}
	
	private static void insertRecord(int id,String name,int price)
	{
		try 
		{
			Connection con = getConnection();
			Statement query = con.createStatement();
			String insert = String.format("insert into dock values('%d','%s','%d')",id,name,price);
			int rowsAffected = query.executeUpdate(insert);
		} 
		catch (Exception e) 
		{
			e.getMessage();
		}
	}
	private static void deleteRecord(int id)
	{
		try {
			Connection con = getConnection();
			String deleteQuery = "delete from dock where id = ?";
			PreparedStatement ps =con.prepareStatement(deleteQuery);
			ps.setInt(1,id);
			int rowsAffect = ps.executeUpdate();
			if(rowsAffect!=1)
			{
				System.out.println("FAILED TO DELETE");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public static void ReadRec() throws  Exception
	{
		Connection con = getConnection();
		if(con == null)
		System.out.println("Connection FAILED to ESTABLISHED");
		Statement query = con.createStatement();
		ResultSet rs  = query.executeQuery(select);
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
		}
	}
	
	public static void main(String[] args) 
	{
		try {
			Scanner ch = new Scanner(System.in);
			int choice=0;
			System.out.println("DOCKER MANAGEMENT");
			int id=0;
			String name=null;
			int price=0;
			do
			{
				System.out.println("1-ADD RECORDS\n2-DELETE RECORD\n3-UPDATE RECORDS\n4-SHOW RECORDS\n5-EXIT\nENTER YOUR CHOICE = ");
				choice = ch.nextInt();
			//choice = Integer.parseInt(System.console().readLine("1-ADD RECORDS\n2-DELETE RECORD\n3-UPDATE RECORDS\n4-SHOW 																			RECORDS\n5-EXIT\nENTER YOUR CHOICE = "));
			//Scanner ch = new Scanner;
			switch (choice) 
			{
			case 1:
				System.out.println("ENTER THE ID = ");
				id = ch.nextInt();
				//name = String.format("ENTER THE NAME = %s",name);
				System.out.println("ENTER THE NAME = ");
				name = ch.next();
				System.out.println("ENTER THE PRICE = ");
				price = ch.nextInt();
				insertRecord(id, name, price);
				break;
			case 2:
				System.out.println("ENTER THE ID = ");
				id = ch.nextInt();
				deleteRecord(id);
				break;
			case 3:
				System.out.println("ENTER THE ID = ");
				id = ch.nextInt();
				System.out.println("ENTER THE NAME = ");
				name = ch.next();
				System.out.println("ENTER THE PRICE = ");
				price = ch.nextInt();
				updateRecord(id, name, price);
				break;
			case 4:
				ReadRec();
				break;
			case 5:
				break;
			}
			}while(choice!=5);	
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}







}
