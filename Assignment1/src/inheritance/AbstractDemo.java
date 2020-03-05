package inheritance;


 abstract class AbDemo1
{
	public abstract void d1();
	
	public void d2()
	{
		System.out.println("This is the method called from Abstract class");
	}
}
 class  AbDemo2 extends AbDemo1{

	@Override
	public void d1() {
		// TODO Auto-generated method stub
		System.out.println("It is called from non abstract class");
	}
	 
 }
public class AbstractDemo {
	public static void main(String[] args) {
		AbDemo2 d=new AbDemo2();
		d.d1();
		d.d2();
	}
}
