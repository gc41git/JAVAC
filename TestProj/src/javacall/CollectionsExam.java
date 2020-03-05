package javacall;
import java.util.*;

public class CollectionsExam 
{

	public static void Array_List()
	{
		ArrayList <Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		arr.add(6);
		arr.add(7);
		System.out.println("The Number of Elements = "+arr.size());
		for (int arrlist : arr)
		{	
			System.out.println(arrlist);
		}
		arr.remove(5);
		System.out.println(arr);
	}

	public static void HashSet_Example()
	{
		Set <String> setter = new HashSet<String>();
		setter.add("THIS");
		setter.add("IS");
		setter.add("AN");
		setter.add("OF");
		setter.add("HASH-SET");
		setter.add("EXAMPLE");
		setter.add("OF");//DUPLICATE
		setter.add("EXAMPLE");//DUPLICATE
		//setter.remove(4);

		for(String set:setter)
		{
			System.out.println(set);
		}
		System.out.println("THE SIZE OF THE HASH SET = "+setter.size());
	}
	
	public static void Onemore_HashSet()
	{
		//int size = 0;
		Set<FirstExcept> onemore = new HashSet<FirstExcept>();
		onemore.add(new FirstExcept(1, "ROHIT"));
		onemore.add(new FirstExcept(2, "DHAWAN"));
		onemore.add(new FirstExcept(3, "KOHLI"));
		onemore.add(new FirstExcept(4, "KL RAHUL"));
		onemore.add(new FirstExcept(4, "KL RAHUL"));
		onemore.add(new FirstExcept(4, "KL RAHUL"));
		for(FirstExcept omore : onemore)
		{
			/*
			 * if(onemore.hashCode()!=omore.hashCode()) {
			 */
			System.out.println(omore.hashCode());
			//System.out.println();
			//size = onemore.size()-1;
			 //System.out.println(size);
		}
		System.out.println("THE SIZE OF THE HASH SET IS = "+onemore.size());
	}
		
		
	public static void Maps()
	{
		Map<String,String> insert = new HashMap<String, String>();
		try 
		{
			insert.put("PATHAK","HEMA");
			insert.put("RAVI","SURBHI");
			insert.put("AKASH","RENU");
			insert.put("SHUBHAM","URUSHA");
			insert.put("SURESH","YAMINI");
		} 
		catch (IllegalArgumentException iae) 
		{
			System.out.println(iae);
		}
		System.out.println("THE NO OF BOYS = "+insert.size());
		Set<String> keys = insert.keySet();
		for(String arr : keys)
		{
			System.out.println("BOYS = "+arr);
			System.out.println("GIRLS = "+insert.get(arr));
		}
		System.out.println(insert);
		
	}
	public static void Que_Example()
	{
		Queue<String> queuer = new LinkedList<String>();
		queuer.add("PUBG");
		queuer.add("COD");
		queuer.add("FORTNITE");
		System.out.println(queuer);
		System.out.println("THE ITEM REMOVED IS = "+queuer.remove());
		System.out.println("THE ITEM RETURED IS = "+queuer.peek());
		System.out.println("THE ITEM IS = "+queuer.poll());
	}
	
	public static void main(String[] args) 
	{
		//Array_List();
		//HashSet_Example();
		//Onemore_HashSet();
		//Maps();
		Que_Example();
	}

}
