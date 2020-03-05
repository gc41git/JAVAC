package inheritance;

class Cat
{
	public void eat()
	{
		System.out.println("eating");
	}
}

class Dog extends Cat
{
	public void work()
	{
		System.out.println("working");
		super.eat();
	}
}
public class SuperUse {
	public static void main(String[] args) {
		Dog d=new Dog();
		d.work();
	}
}
