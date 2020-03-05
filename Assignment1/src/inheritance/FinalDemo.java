package inheritance;


final class Final1{
	public void f1()
	{
		System.out.println("This is the Final class");
	}
}

class FDemo1
{
	public final void f2()
	{
		System.out.println("It is the final method of base class");
	}
	public void f1()
	{
		System.out.println("it is the method of base class");
	}
}

class FDemo2 extends FDemo1
{
	public void f1()
	{
		System.out.println("It is the method of dervied class");
	}
}


public class FinalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FDemo1 f1=new FDemo1();
		f1.f2();
		f1.f1();
		FDemo2 f=new FDemo2();
		f.f1();
	}

}
