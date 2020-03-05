package demohib;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Dao 
{
	private SessionFactory sessfact;

	public void setSessfact(SessionFactory sessfact) {
		this.sessfact = sessfact;
		System.out.println("JDBC DONE");
	}
	
	public Customer addCustomer(Customer cc)
	{
		Session s = sessfact.openSession();
		Transaction tr = s.beginTransaction();
		s.save(cc);
		tr.commit();
		s.close();
		System.out.println("Inserted Successfully");
		return cc;
	}
	
	public void updCustomer(Customer ccu)
	{
		Session su = sessfact.openSession();
		Transaction tr = su.beginTransaction();
		su.update(ccu);
		tr.commit();
		su.close();
		System.out.println("Update Successfull");
	}
	
	public Customer singleSelect(String custid)
	{
		Session s = sessfact.openSession();
		Customer cg = s.get(Customer.class,custid);
		s.close();
		return cg;
	}
	
	public void delete(String custid)
	{
		Session s = sessfact.openSession();
		Transaction t = s.beginTransaction();
		Customer cd = s.get(Customer.class, custid);
		s.delete(cd);
		t.commit();
		s.close();
		System.out.println("DELTED SUCCESSFULLY");
	}
	
	/*
	 * public void store(Customer c) { Session s = sessfact.openSession();
	 * Transaction tr = s.beginTransaction(); s.save(c); c.setCustid("DAC11");
	 * tr.commit(); s.close();
	 * 
	 * }
	 */
	
	public List<Customer> getAll(String city)
	{
		Session s = sessfact.openSession();
		Query<Customer> q = s.createQuery("from Customer where city = '"+city+"'");
		List<Customer> cc = q.list();
//		if(cc.size()==0)
//		{
//			System.out.println("no CUstomer found");
//		}
//		else
//		{
//			System.out.println(cc.iterator());
//		}
		s.close();
		return cc;
		
	}
	
	
	
}
