package exceptionalHandling;

public class ThrowExample {
	
	public static void demo()
	{
		System.out.println("Inside function");
		throw new NullPointerException();
	}
public static void main(String[] args) {
	try {
	demo();
	}
	catch(NullPointerException e)
	{
		System.out.println("Exception caught");
	}
	
}
}
