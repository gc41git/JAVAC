package interfacedemo;

interface Bank
{
	public abstract void checkBalance();
	public abstract void debit();
	public abstract void credit();
	
}
class SBIBank implements Bank
{

	@Override
	public void checkBalance() {
		// TODO Auto-generated method stub
		System.out.println("Check your balance");
	}

	@Override
	public void debit() {
		// TODO Auto-generated method stub
		System.out.println("money debited");
	}

	@Override
	public void credit() {
		// TODO Auto-generated method stub
		System.out.println("money credited");
	}
	
}


public class InterfaceExample {

	public static void main(String[] args) {
	
		Bank b=new SBIBank();
		b.checkBalance();
		b.credit();
	}
}
