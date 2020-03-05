package com.aop;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopDemo 
{
	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("core.xml");
		BegTrans bt = cpx.getBean(BegTrans.class);
		bt.bt2();
		
	}

}
