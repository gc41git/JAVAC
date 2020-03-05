package demospring;

public class A 
{

	private int a =10;
	private int b = 5;
	public int getB() 
	{
		return b;
	}
	public void setB(int b) 
	{
		this.b = b;
	}
	public int getA() 
	{
		return a;
	}
	public void setA(int a) 
	{
		this.a = a;
	}
	public A()
	{
		System.out.println("THIS IS A CONSTRUCTOR");
	}
	public void testFunc()
	{
		System.out.println("THIS IS A TEST FUNCTION");
		System.out.println(a);
		System.out.println(b);
	}
}
