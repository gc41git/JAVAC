package com.aop;

public class EndTrans
{
	public EndTrans()
	{
		System.out.println("In End Transaction");
	}
	
	public void et1()
	{
		System.out.println("Transaction has started");
	}	
	public void et2() 
	 { 
		 System.out.println("Transaction has been processed");
	 }
	public void et3() 
	{
		System.out.println("Transaction has ENDED"); 
	}
	 
}
