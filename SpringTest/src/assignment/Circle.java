package assignment;

import java.util.Scanner;

public class Circle 
{
	float radius = 0.0f;
	
	//Scanner scn = new Scanner(System.in);
	

	public float getRadius() {
		return radius;
	}


	public void setRadius(float radius) {
		this.radius = radius;
	}
	public Circle()
	{
		System.out.println("This is Circle Constructor");
	}


	public double calcper()
	{
		double perimeter = 2*3.14*radius;
		return perimeter;
		
	}
	
	
	
	
}
