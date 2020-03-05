package basics;

class BaseInheritDemo 
{
	public BaseInheritDemo()
	{
		System.out.println("THIS IS BASE CLASS CONSTRUCTOR");
		
	}
	
	public BaseInheritDemo(String st)
	{ 
		this();
		System.out.println(st);
	}
	
	public void base()
	{
		System.out.println("THIS IS BASE CLASS FUNCTION");
	}
	
}

class Inheriter extends BaseInheritDemo
{
	public Inheriter() 
	{
		//super();
		super("PARAMETRISED");
		//name="derived class parameter";
		//System.out.println(name);
	}
	
	@Override
	public void base()
	{
		System.out.println("THIS IS OVERRIDED FUNCTION");
	}
}

public class InheritDemo
{
	public static void main(String[] args) 
	{
		Inheriter ih = new Inheriter();
		ih.base();
	}
}
