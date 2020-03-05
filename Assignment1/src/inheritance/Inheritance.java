package inheritance;


class Demo1
{
	String value;
	public Demo1(String value)
	{
		this.value=value;
	}
	public void d1()
	{
		System.out.println("This is the method of the base class");
	}
}

class Demo2 extends Demo1
{
	String value1;
	public Demo2(String value1) {
		super("constructor of base class");
		System.out.println(value);
	}
	public void d2()
	{
		System.out.println("This is the method of derived class");
	}
	public void d1()
	{
		System.out.println("This is the overridden method of the base class");
	}
}

public class Inheritance {
	public static void main(String[] args) {
		Demo2 d=new Demo2("This is the use of super class");
		d.d2();
		d.d1();
	}
}
