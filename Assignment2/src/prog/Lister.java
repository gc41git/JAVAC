package prog;

import java.util.ArrayList;
import java.util.List;

class ListOperate
{
	List<String> mylist  = new ArrayList<String>();
	public List<String> addelement()
	{
		mylist.add("THIS");
		mylist.add("IS");
		mylist.add("LIST");
		mylist.add(2, "Array");//adding via providing index
		
		
		 for(String data : mylist) 
		 {
			 System.out.println(data); 
		 }
		return mylist;
	}
	public int size()
	{
		int sizer= mylist.size();
		return sizer;
	}
	
	public List<String> update()
	{
		mylist.set(1, "is an");//replace via providing index
		return mylist;	
	}
	
	public void search(String cnt)
	{
		if(mylist.contains(cnt))
		{
			System.out.println("Content is present in the list");
		}
		else
		{
			System.out.println("Content not in the list");
		}
	}
}
public class Lister 
{
	public static void main(String[] args) {
		ListOperate lo  = new ListOperate();
		lo.addelement();
		//System.out.println(lo.addelement());
		System.out.println(lo.size());
	}

}
