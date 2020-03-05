package dataStructure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class MapOperation
{
	HashMap h=new HashMap();
	
	public Map addMap()
	{
		h.put(1, "neha");
		h.put(2, "Anjali");
		h.put(3, "Renuka");
		return h;
	}
	
	public String getMap(int key)
	{
		return (String) h.get(key);
	}
	
	public void removeEle(int key)
	{
		h.remove(key);
	}
}
public class MapExample {

	public static void main(String[] args) {
		MapOperation m=new MapOperation();
		
		//////////////// adding elemnet to map///////////////////////
		Map md=m.addMap();
		Set set=md.entrySet();
		Iterator itr=set.iterator();
		
		while(itr.hasNext())
		{
			Map.Entry entry=(Map.Entry) itr.next();
			System.out.println(entry.getKey()+ "  "+entry.getValue());
		}
		
		//////// Getting element from map//////////////////// 
		String name=m.getMap(2);
		System.out.println(name);
		
		/////////////removing element//////////
		
		m.removeEle(3);
		Iterator itr1=set.iterator();
		while(itr1.hasNext())
		{
			Map.Entry entry=(Map.Entry) itr.next();
			System.out.println(entry.getKey()+ "  "+entry.getValue());
		}
		
	}
}
