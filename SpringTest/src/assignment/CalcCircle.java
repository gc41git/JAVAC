package assignment;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcCircle 
{
	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("note.xml");
		
		System.out.println("This is from main method");
		
		Circle cc = cpx.getBean("calc", Circle.class);
		System.out.println(cc.getRadius());
		System.out.println(cc.calcper());
		
		
		
	}
	

}
