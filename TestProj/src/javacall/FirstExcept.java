package javacall;

import java.util.*;

class FailedException extends Exception
{	
	public FailedException()
	{
		
	}
	public FailedException(String message)
	{
		super (message);
	}
}
class ThrowException
{
	public List<FirstExcept> excepter = new ArrayList<FirstExcept>();
	public void addException(FirstExcept feEx) throws FailedException
	{
		if(feEx==null)
		{
			throw new FailedException("INFO NOT FOUND");
		}
		excepter.add(feEx);
		System.out.println("ENTERED SUCCESSFULLY");
	}
}
public class FirstExcept {
	int id;
	String Name;
	
	@Override
	public int hashCode()
	{
		return Integer.hashCode(id);
		
	}

	public FirstExcept(int id, String Name) 
	{ 
		this.id=id; this.Name=Name; 
	}
	 
	private static void SimpleCatch() {
		System.out.println("ENTER A NUMBER");
		Scanner sn = new Scanner(System.in);
		try {
			int num = sn.nextInt();
			// System.console().printf("%d",num);
			System.out.println(String.format("%d", num));

		} catch (InputMismatchException ex) {
			System.out.println("Invalid Number and the Exception is = " + ex);
		} finally {
			System.out.println("THIS IS FINAL BLOCK");
		}
	}

	private static void MultipleCatch() {
		boolean validate = true;
		int[] elements = { 11, 12, 13, 14, 15 };
		do {
			try {
				// int index = Integer.parseInt(System.console().readLine("ENTER THE INDEX OF
				// THE ARRAY"));
				System.out.println("Enter a Number");
				Scanner sn = new Scanner(System.in);
				int index = sn.nextInt();
				System.out.println("THE VALUE AT = " + index + " AND THE ELEMENT IS = " + elements[index]);
				validate = true;
			} catch (InputMismatchException inp) {
				System.out.println("Invalid Index No And The Exception is = " + inp);
				validate = false;
			} catch (ArrayIndexOutOfBoundsException arrexcep) {
				System.out.println("THE SIZE OF THE ARRAY IS EXCEEDED AND THE EXCEPTION IS = " + arrexcep);
				validate = false;
			}

			finally {
				System.out.println("THIS IS THE SECOND FINAL BLOCK");
				validate = false;
			}

		} while (validate != true);

	}

	public static void CalcExcept() {
		boolean res = true;
		do {
			try {
				System.out.print("ENTER THE FIRST NUMBER = ");
				Scanner fn = new Scanner(System.in);
				int first = fn.nextInt();
				System.out.print("ENTER THE SECOND NUMBER = ");
				int second = fn.nextInt();
				int div = first / second;
				System.out.println(first + "/" + second + " = " + div);
				res = false;
				// Dividing by zero 0 returns an exception which is
				// java.lang.ArithemeticException when the data type is of Integer(int) type
			} catch (ArithmeticException aex) {
				System.out.println("DIVIDE BY ZERO IS NOT POSSIBLE AND THE EXCEPTION IS = " + aex);
				res = false;
			} finally {
				System.out.println("THIRD FINAL BLOCK");
				res = false;
			}
		} while (res != true);
	}

	public static void ThirdExcept() {
		try {
			FirstExcept fex = new FirstExcept(42, "HARRISON");
			//System.console().printf(String.format("THE ID IS = %d AND THE NAME IS = %s",fex.id,fex.Name));;
			System.out.println("THE ID  IS = " + fex.id + " \nTHE NAME IS = " + fex.Name);
		} catch (NullPointerException nex) {
			System.out.println("THE OBJECT IS NOT INSTANTIATED AND THE EXCEPTION IS = " + nex);
		}
	}
	
	public static void FourthExcept()
	{
		ThrowException thExe = new ThrowException();
		try 
		{
			FirstExcept fexe = new FirstExcept(18,"WARNER");
			thExe.addException(fexe);
		}
		catch (FailedException fail) 
		{
			System.out.println(fail.getMessage());
		}
	}

	public static void main(String[] args) {
		// SimpleCatch();
		// MultipleCatch();
		// CalcExcept();
		//ThirdExcept();
		FourthExcept();
	

	}

}
