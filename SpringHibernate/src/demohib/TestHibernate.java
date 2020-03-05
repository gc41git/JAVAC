package demohib;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHibernate
{
	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("conf.xml");
		Customer cc = new Customer();
		Scanner scn = new Scanner(System.in);
		
		Dao d = cpx.getBean(Dao.class);
		//d.addCustomer(c);
		//System.out.println(d.getAll("DAC11"));
		//List<Customer> cc = d.getAll("Lucknow");
		//System.out.println(cc);
		//d.getAll("DAC11");
		//System.out.println(d.singleSelect(c.getCustid()));
//		System.out.println("Enter the Customer's ID = ");
//		c.custid=scn.next();
//		Customer cc = d.singleSelect(c.custid); 
//		System.out.println(cc);
		//d.delete("DAC11");
		//d.store(c);
		//d.search(c.getCustid());
		//d.updCustomer(c);
//		System.out.println("Enter the Customer's ID = ");
//		c.custid=scn.next();
		
			int choice = 0;
			
			do
			{
				System.out.println("1-Enter Customer\n2-Update Customer\n3-Delete Customer\n4-Single Select\n5-Multi Select\n6-Exit\nEnter your choice - ");
				choice = scn.nextInt();
			switch (choice) 
			{
			case 1:
			{		
						//cc = null;
						System.out.println("Enter the Customer's ID = ");
						cc.custid=scn.next();
						//scn.hasNext(cc.setCustid(cc.custid));
						System.out.println("Enter the Customer's Name = ");
						cc.customer=scn.next();
						System.out.println("Enter the Customer's Passwords = ");
						cc.passwords=scn.next();
						System.out.println("Enter the Customer's Rewards = ");
						cc.rewards=scn.next();
						System.out.println("Enter the Customer's City = ");
						cc.city=scn.next();
						d.addCustomer(cc);
						break;
			}		
			case 2:
					
						//cc = null;
			{
						System.out.println("Enter the Customer's ID to be Updated = ");
						cc.custid=scn.next();
						System.out.println("Enter the Customer's Name = ");
						cc.customer=scn.next();
						System.out.println("Enter the Customer's Passwords = ");
						cc.passwords=scn.next();
						System.out.println("Enter the Customer's Rewards = ");
						cc.rewards=scn.next();
						System.out.println("Enter the Customer's City = ");
						cc.city=scn.next();
						d.updCustomer(cc);
						break;
			}
			case 3:
			{
					    System.out.println("Enter the Customer's ID to be Deleted = ");
					    cc.custid = scn.next();
					    d.delete(cc.getCustid());
					    break;
			}	
			case 4:
			{	 		System.out.println("Enter the Customer's ID to be Search = ");
						cc.custid=scn.next();
						cc = d.singleSelect(cc.custid); 
						System.out.println(cc);
						break;
			}
			case 5:
			{			System.out.println("Enter the Customer's City to Searched = ");
				 		cc.city = scn.next();
				 		List<Customer> c = d.getAll(cc.city);
				 		System.out.println(d.getAll(cc.city));
						break;
			}	
			
			case 6:
			{
						System.out.println("EXITED SUCCESSFULLY");
						break;
			}
			
			
			}
			}while(choice!=6);
		
		}
	

}
