package exceptionalHandling;

public class TryCatchExamplee {

	public static void main(String[] args) {
		
		
		try {
			System.out.println(10/0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Divide by 0");
		}
		finally {
			System.out.println("In finally block");
		}
	}
}
