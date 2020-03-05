package demospring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DSpring 
{
	
	
	
	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext cpx  = new ClassPathXmlApplicationContext("note.xml");	
		
		System.out.println("HELLO WORLD");
		
		A tester = cpx.getBean("test" ,A.class);
		tester.testFunc();
	}
}
