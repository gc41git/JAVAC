package javacall;
import java.sql.*;
import java.util.Scanner;

public class StudOperate 
{
	final static String url = "jdbc:mysql://localhost:3310/dacers?serverTimezone=UTC";
	//final static String url = "jdbc:mysql://127.0.0.1:3310/dacers?serverTimezone=UTC";
	final static String user = "root";
	final static String pass = "";
	
	static Connection connectify() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection join = DriverManager.getConnection(url, user, pass);
		return join;	
	}
	
	public static void AddFriend(int prn,String name,String aoi) throws Exception
	{
		try {
			Connection join = connectify();
			if(join==null)
			{
				System.out.println("Connection failed to establish");
			}
			//Statement query = join.createStatement();
			String query = "insert into hangouts(prn,name,aoi) values(?,?,?)";
			PreparedStatement ps = join.prepareStatement(query);
			ps.setInt(1, prn);
			ps.setString(2, name);
			ps.setString(3, aoi);
			ps.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public static void UpdateFriend(int prn,String name,String aoi) throws Exception
	{
		try {
			Connection join = connectify();
			if(join==null)
			{
				System.out.println("Connection failed to establish");
			}
			String query = "update hangouts set name = ? , aoi= ? where prn = ?";
			PreparedStatement ps = join.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2,aoi);
			ps.setInt(3,prn);
			ps.executeUpdate();
			
		} catch (SQLException se) {
			se.printStackTrace();
			
		}
	}
	
	public static void UnFriend(int prn) throws Exception
	{
		try {
			Connection join = connectify();
			if(join == null)
			{
				System.out.println("Connection Failed To Establish");
			}
			String query = "delete from hangouts where prn = ?";
			PreparedStatement ps = join.prepareStatement(query);
			ps.setInt(1, prn);
			ps.executeUpdate();
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public static void FindFriend(int prn) throws Exception
	{
		try {
			Connection join = connectify();
			Statement query = join.createStatement();
			String friend = "select prn,name,aoi from hangouts where prn = '"+prn+"'";
			ResultSet rs = query.executeQuery(friend);
			{
				
				while(rs.next())
				{
					System.out.println("The PRN ID = "+rs.getInt(1));
					System.out.println("The NAME IS = "+rs.getString(2));
					System.out.println("The AOI IS = "+rs.getString(3)+"\n");
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	/*
	 * public static void CountFriend() throws Exception { try { Connection join =
	 * connectify(); Statement query = join.createStatement(); String friend =
	 * "select count(*) from hangouts"; ResultSet rs = query.executeQuery(friend); {
	 * 
	 * while(rs.next()) {
	 * System.out.println("The Total Number of friends are = "+rs.getInt(1)); }
	 * //System.out.println("The Total Number of friends are = "+rs.getInt(1)); } }
	 * catch (SQLException se) { se.printStackTrace(); } }
	 */
	
	public static void FilterFriend(String aoi) throws Exception
	{
		try {
			Connection join = connectify();
			Statement query = join.createStatement();
			String friend = "select count(prn) from hangouts where aoi = '"+aoi+"'";
			ResultSet rs = query.executeQuery(friend);
			{
				
				while(rs.next())
				{
					System.out.println("The Number of friends with AOI - "+aoi+" are = "+rs.getInt(1));
				}
				
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public static void AvgFriend(String aoi) throws Exception
	{
		try {
			Connection join = connectify();
			Statement query = join.createStatement();
			String friend = "select AVG(prn) from hangouts where aoi = '"+aoi+"'";
			ResultSet rs = query.executeQuery(friend);
			{
				
				while(rs.next())
				{
					System.out.println("The Average is = "+rs.getInt(1));
				}
				
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public static void FriendList() throws Exception
	{
		try 
		{
			Connection join = connectify();
			if(join == null )
			{
				System.out.println("Connection failed to establish");
			}
			Statement query = join.createStatement();
			String show = "select * from hangouts";
			ResultSet rs = query.executeQuery(show);
			
			while(rs.next())
			{
				System.out.println("The PRN ID is = "+rs.getInt(1));
				System.out.println("The Name is = "+rs.getString(2));
				System.out.println("The Aoi is = "+rs.getString(3)+"\n");
			}
			
			String count = "select count(*) from hangouts";
			rs = query.executeQuery(count);
			while(rs.next())
			{
				System.out.println("The Total Number Of Friends Are = "+rs.getInt(1)+"\n");
			}
		} 
		catch (SQLException se) 
		{
			se.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		try 
		{
			Scanner sn = new Scanner(System.in);
			int prn = 0;
			String name = null;
			String aoi=null;
			int choice = 0;
			do {
			System.out.println("1-Add Friend \n2-Update Friend \n3-Delete Friend \n4-Show Friend\n5-All Friend \n6-Filter Friends \n7-Avg Friend \n8-Exit\nEnter Your Choice = ");
			choice = sn.nextInt();
			switch(choice)
			{
				case 1:
					System.out.println("Enter The Prn = ");
					prn = sn.nextInt();
					System.out.println("Enter The Name = ");
					name = sn.next();
					name += sn.nextLine();
					System.out.println("Enter The Aoi = ");
					aoi = sn.nextLine();
					AddFriend(prn, name, aoi);
					break;
				case 2:
					System.out.println("Enter The Prn = ");
					prn = sn.nextInt();
					System.out.println("Enter The Name = ");
					name = sn.next();
					name += sn.nextLine();
					System.out.println("Enter The Aoi = ");
					aoi = sn.nextLine();
					UpdateFriend(prn, name, aoi);
					break;
				case 3:
					System.out.println("Enter The Prn = ");
					prn = sn.nextInt();
					UnFriend(prn);
					break;
				case 4:
					System.out.println("Enter The Prn = ");
					prn = sn.nextInt();
					FindFriend(prn);
					break;
				case 5:
					FriendList();
					break;
				case 6:
					System.out.println("Enter The Aoi = ");
					aoi = sn.next();
					FilterFriend(aoi);
					break;
				case 7:
					System.out.println("Enter The Aoi = ");
					aoi = sn.next();
					AvgFriend(aoi);
					break;
				case 8:
					return;		
			}
			}
			while(choice!=8);
		} 
		catch (SQLException se) 
		{
			se.printStackTrace();
		}
	}
}


