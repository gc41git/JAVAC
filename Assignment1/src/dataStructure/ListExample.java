package dataStructure;

import java.util.ArrayList;
import java.util.List;

class ListOperation
{
	List<String>list=new ArrayList<String>();
	public List<String> addList()
	{
	list.add("neha");
	list.add("Renuka");
	list.add("Anjali");

	return list;
	}
	
	public List<String> modifyList()
	{
		list.set(1, "priya");
		list.set(0, "Rutika");
		return list;
	}
	
	public void searchList(String name)
	{
		if(list.contains(name))
		{
			System.out.println(name +" is in the list");
		}
		else
		{
			System.out.println("name is not in the list");
		}
	}
}
public class ListExample {
	public static void main(String[] args) {
		ListOperation lo=new ListOperation();
		List<String> s=lo.addList();
		for(String e : s)
		{
			System.out.println(e);
		}
		System.out.println("After modification");
		
		List<String> s2=lo.modifyList();
		for(String e2 : s2)
		{
			System.out.println(e2);
		}
		
		lo.searchList("Anjali");
	}
}
