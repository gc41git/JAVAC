package exceptionalHandling;

public class ThrowsExample {
	
	public static void Division() throws ArithmeticException
	{
		int c=10/0;
		System.out.println(c);
	}
	public static void main(String[] args) {
		Division();
	}
}
