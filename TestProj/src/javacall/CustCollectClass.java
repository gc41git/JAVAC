package javacall;

import java.util.*;
import java.lang.*;

class CollectClass
{
	private int gid;
	private String name;
	private double price;
	
	public String toString()
	{
		return String.format("The Id is = %d\nThe Name is = %s\nThe Price is=%f",gid,name,price);
	}
	
	public int getGid()
	{
		return gid;
	}
	
	public String getName()
	{
		return name;
	}
	public double getPrice()
	{
		return price;
	}
	
	public CollectClass(int gid,String name,double price) {
		this.gid=gid;
		this.name=name;
		this.price=price;
	}
}

class CustomCollect implements Iterable<CollectClass>
{
	public List<CollectClass> cClass = new ArrayList<CollectClass>();
	public void addGame(CollectClass Cc)
	{
		cClass.add(Cc);
	}

	public void updateGame(CollectClass Cc) throws Exception
	{
		for(int i=0;i<cClass.size();i++)
		{
			CollectClass tempClass = cClass.get(i);
			if(tempClass.getGid()==Cc.getGid())
			{
				cClass.add(i,Cc);
			}
		}
		throw new Exception("Not Found Exception");
	}
	
	public void deleteGame(int gid) throws Exception
	{
		for(int i=0;i<cClass.size();i++)
		{
			if(cClass.get(i).getGid()==gid)
			{
				cClass.remove(i);
				return;
			}
		}throw new Exception("NOT FOUND");
	}
	public List<CollectClass>Find(String title) {
		List<CollectClass>cC = new ArrayList<CollectClass>();
		for(CollectClass collect : cClass)
		{
			if(collect.getName().contains(title))
				cC.add(collect);
		}
		return cC;
		
	}
	
	@Override
	public Iterator<CollectClass> iterator() {
		
		return cClass.iterator();
	}
	
}


public class CustCollectClass {
	public static void main(String[] args) {
		try
		{
			CustomCollect ccl = new CustomCollect();
			ccl.addGame(new CollectClass(01, "PUBG", 999));
			ccl.addGame(new CollectClass(02, "COD", 1200));
			ccl.addGame(new CollectClass(03, "FORTNITE", 0));
			
			Iterator<CollectClass> cll = ccl.iterator();
			while(cll.hasNext())
				System.out.println(cll.next());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
