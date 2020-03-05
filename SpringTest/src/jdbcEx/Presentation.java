package jdbcEx;

import java.util.List;
import java.util.Scanner;

public class Presentation
{
	private Dao jx;
	
	public void setMeth(Dao dao)
	{
		System.out.println("Dao IS HERE");
		this.jx=dao;
	}
	
	void singleSelect()
	{
		
		 //Scanner lgn = new Scanner(System.in);
		 //System.out.println("Enter the Customer ID = ");
		 
		String custid="DAC01";
		System.out.println(custid);
		//custid = lgn.next();
		Customer cc = jx.singleselect(custid);
		//System.out.println(custid);
		if(cc.getCustid()!=null)
		{
			System.out.println("Custid is not found");
			
		}
		else
		{
			System.out.println(cc.getCustomer());
			System.out.println(cc.getCity());
			System.out.println(cc.getPasswords());
			System.out.println(cc.getRewards());
			
		}
	}
	
	
	  public void deleteCust() 
	  { 
		  
		 
		  
		
		 Scanner scn = new Scanner(System.in);
		 String custid = null;
		 
		  try {
		  //System.out.println("Enter the customer id = "); 
		  //c.getCustid(scn.next());
		  //c.setCustid(scn.next());
		  }
		  catch (Exception e) {
			  e.printStackTrace();
		  }
		  
		 boolean delcheck = jx.deleteDb(custid);
		 if(delcheck)
		 {
			 System.out.println("Deleted Successfully");
		 }
		 else
		 {
			 System.out.println("CustID not Found");
		 }
	  }
	 
	
	public void InsertCust()
	{
		Customer c = new Customer();
		Scanner ins = new Scanner(System.in);
		try
		{
			System.out.println("Enter customer id = ");
			c.setCustid(ins.next());
			System.out.println("Enter customer  = ");
			c.setCustomer(ins.next());
			System.out.println("Enter passwords = ");
			c.setPasswords(ins.next());
			System.out.println("Enter rewards = ");
			c.setRewards(ins.next());
			System.out.println("Enter city = ");
			c.setCity(ins.next());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		boolean stat = jx.insertDb(c);
		if(stat)
		{
			System.out.println("Customer added");
		}
		else
		{
			System.out.println("Failed in added");
		}
	}
	
	public void UpdateSelected()
	{
		String custid  = "DAC01";
		Customer up = jx.singleselect(custid);
		//System.out.println(custid);
		
		up.setCustid("DAC13");
		up.setCustomer("Syed");
		up.setPasswords("syed");
		up.setRewards("250ADV");
		up.setCity("Basti");
		
		boolean ccup  = jx.updateQuery(up);
		if(ccup)
		{
			System.out.println(ccup);
			System.out.println("Updated Successfully");
			System.out.println(up.getCustid());
			System.out.println(up.getCustomer());
			System.out.println(up.getPasswords());
			System.out.println(up.getRewards());
			System.out.println(up.getCity());
		}
		else
		{
			System.out.println("Custid Not Found");
		}
	}
	
	public void multiSelector()
	{
		//Scanner lgn = new Scanner(System.in);
		//System.out.println("ENTER THE CITY");
		String city = "Lucknow";//lgn.next();
		
		List<Customer> c = jx.multiSelect(city);
		System.out.println(c.size());
		if(c.size()==0)
		{
			System.out.println("No Customer Found");
		}
		else
		{
//			System.out.println(c.size());
			System.out.println(c);
			System.out.println(c.iterator());
//			System.out.println(c.get(1));
//			System.out.println(c.listIterator());
//			System.out.println(c.get(1));
//			System.out.println(c.get(2));
//			System.out.println(c.get(3));
//			System.out.println(c.get(4));
			
		}
	}
}