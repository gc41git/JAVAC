package prog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Customerdb {		
	static Connect cn = new Connect();
	public static void addCustomer(String custid, String customer, String passwords, String rewards, String city)
			throws Exception 
	{

		try 
		{
			// Statement query = join.createStatement();
			Connection join = cn.connectify();
			if (join == null) {
				System.out.println("Connection failed to establish");
			}
			String query = "insert into pass(custid,customer,passwords,rewards,city) values(?,?,?,?,?)";
			PreparedStatement ps = join.prepareStatement(query);
			ps.setString(1, custid);
			ps.setString(2, customer);
			ps.setString(3, passwords);
			ps.setString(4, rewards);
			ps.setString(5, city);
			ps.executeUpdate();
		}
		catch (SQLException se) 
		{
			se.printStackTrace();
		}
	}
	
	public static int checkCustomer(String id)
	{
		Scanner chk  = new Scanner(System.in);
		int a = 0;
		try 
		  { 
			  Connection join = cn.connectify(); 
			  if(join==null) 
			  {
			  System.out.println("Connection failed to establish"); 
			  } 
		  Statement query = join.createStatement(); 
		  String ql = "select * from pass where custid='"+id+"'";
		  ResultSet rs = query.executeQuery(ql);  
				  while(rs.next()) 
			  	  { 
				  System.out.println("The Customer Id = "+rs.getString(1)); 
				  System.out.println("The Customer Name = "+rs.getString(2)); 
				  System.out.println("The Customer Password = "+rs.getString(3)); 
				  System.out.println("The Customer Rewards = "+rs.getString(4));
				  System.out.println("The Customer City = "+rs.getString(5)); 
				  a=1;
			  	  }
				  
				  
				  
				  if(rs==null)
				  {
					  a=0;
				  }
		  } 
		
		  catch (Exception e) 
		  { // TODO Auto-generated catch block
		  e.printStackTrace(); 
		  }
		if(a==1)
		{
			int pchoice=0;
			  System.out.println("1-Update\n2-Delete\n3-Main Menu\nEnter Your Choice = ");
			  pchoice = chk.nextInt();
			  String custid=null,customer=null,passwords=null,rewards=null,city=null;
			  switch(pchoice)
			  {
			  
			  	case 1: 
			  	{
			  		
					System.out.println("Enter the Customer Id=");
					custid = chk.next();
					System.out.println("Enter the Customer Name=");
					customer = chk.next();
					System.out.println("Enter the Password=");
					passwords=chk.next();
					System.out.println("Enter the Rewards=");
					rewards=chk.next();
					System.out.println("Enter the City=");
					city=chk.next();
					updateCustomer(custid, customer, passwords, rewards, city);
					System.out.println("DATA UPDATED SUCCESSFULLY");
					break;
			  	}
			  	case 2:
			  	{
			  		System.out.println("Enter the Customer Id=");
					custid = chk.next();
					deleteCustomer(custid);
					System.out.println("Data Deleted Successfully");
					break;
			  		
			  	}
			  	case 3:
			  	{
			  		//join.close();//CLOSING CONNECTION
			  		main(null);
			  		
			  		break;
			  	}
			  }
			return 1;
		}
		else
		return 0;
		 
	}
	
	public static void updateCustomer(String custid, String customer, String passwords, String rewards, String city)
	{
		try {
			Connection join = cn.connectify();
			if(join==null)
			{
				System.out.println("Connection failed to establish");
			}
			String query = "update pass set customer = ? , passwords= ? , rewards = ? , city = ? where custid = ?";
			PreparedStatement ps = join.prepareStatement(query);
			ps.setString(1, customer);
			ps.setString(2,passwords);
			ps.setString(3,rewards);
			ps.setString(4,city);
			ps.setString(5,custid);
			ps.executeUpdate();
			
		} catch (Exception se) {
			se.printStackTrace();
			
		}
	}
	
	public static void deleteCustomer(String custid)
	{
		try {
			Connection join = cn.connectify();
			if(join == null)
			{
				System.out.println("Connection Failed To Establish");
			}
			String query = "delete from pass where custid = ?";
			PreparedStatement ps = join.prepareStatement(query);
			ps.setString(1, custid);
			ps.executeUpdate();
			
		} catch (Exception se) {
			se.printStackTrace();
		}
	}

	public static void checkCity(String city)
	{
		try 
		  { 
			  Connection join = cn.connectify(); 
			  if(join==null) 
			  {
			  System.out.println("Connection failed to establish"); 
			  } 
		  Statement query = join.createStatement(); 
		  String ql = "select customer from pass where city='"+city+"'";
		  ResultSet rs = query.executeQuery(ql);  
				  while(rs.next()) 
			  	  { 
				  System.out.println("The Customer Name = "+rs.getString(1));  
			  	  }
				  
		  } 
		
		  catch (Exception e) 
		  { // TODO Auto-generated catch block
		  e.printStackTrace(); 
		  }
	}
	
	public static void Login(String log,String pass) {
		Scanner lgn = new Scanner(System.in);
		ResourceBundle r = ResourceBundle.getBundle("sys");
		/*
		 * log = r.getString("custid"); pass = r.getString("password");
		 */
		if(log.equals(r.getString("custid"))&&pass.equals(r.getString("password")))
		{
			System.out.println("User is Valid");
			int choice =0;
			System.out.println("1-Enter Customer\n2-Enter City\n3-Logoff\nEnter your choice = ");
			choice = lgn.nextInt();
			switch(choice)
			{
				case 1 : 
				{
					String id = null;
					System.out.println("Enter the Customer id to find = ");
					id = lgn.next();
					//checkCustomer(name);
					if(checkCustomer(id)==0)
					{
						int a = 0;
						System.out.println("The Entered Customer id is not found \n Do yow want to enter a new record (1/0)= ");
						a  = lgn.nextInt();
						if(a==1)
						{
							try 
							{
							String custid=null,customer=null,passwords=null,rewards=null,city=null;
							System.out.println("Enter the Customer Id=");
							custid = lgn.next();
							System.out.println("Enter the Customer Name=");
							customer = lgn.next();
							System.out.println("Enter the Password=");
							passwords=lgn.next();
							System.out.println("Enter the Rewards=");
							rewards=lgn.next();
							System.out.println("Enter the City=");
							city=lgn.next();
							addCustomer(custid, customer, passwords, rewards, city);
							System.out.println("DATA ENTERED SUCCESSFULLY");
							} 
							catch (Exception e) 
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						else
						{
							main(null);
						}
							
					}
					break;
				}
				case 2:
				{
					String city=null;
					System.out.println("Enter the name of the City");
					city=lgn.next();
					checkCity(city);
					break;
				}
				case 3:
				{
					main(null);
					break;
				}
			}
			
		}
		else
		{
			System.out.println("User is Invalid");
			String name = null;
			main(null);
			
		
		}	 

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		String log = null;
		String pass = null;
		String name = null;
		int ch = 0;
		//do
		//{
			System.out.println("1-Login\n2-Exit\nEnter your choice=");
			ch=scn.nextInt();
			switch (ch) 
			{
			case 1:
					{
						System.out.println("Enter the Customer Id=");
						log = scn.next();
						System.out.println("Enter the Password=");
						pass=scn.next();
						Login(log, pass);
						break;
					}
			case 2:
					{
//						System.out.println("Enter the Name of The Customer");
//						name = scn.next();
//						checkCustomer(name);
						break;
					}
			}
		//}while(ch!=2);
	
	}
}
