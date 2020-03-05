package javacall;

//import javacall.RunnableSecond.MyThreadClass;

public class MultiThreading {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * MultiThreading o1=new MultiThreading(new RunnableThread()); MultiThreading
		 * o2=new MultiThreading(new RunnableTh()); o1.run(); o2.run();
		 * 
		 * Thread thw = new Thread(new RunnableThread()); Thread thwe = new Thread(new
		 * RunnableTh()); thw.start(); thwe.start();
		 */

		
		  RunnableThread rt = new RunnableThread(); //RunnableTh th = new RunnableTh();
		  rt.usingRunnableInterface();
		  
		/*
		 * MyThreadClass my = new MyThreadClass(); //my.run(); my.usingThreadClass();
		 */
	}
}

class RunnableThread implements Runnable {

	@Override
	public void run() {
		try {
			for (int i = 0; i < 15; i++) {
				System.out.print("\nThe Thread with Beep#" + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public void usingRunnableInterface() throws InterruptedException
	{
		RunnableThread th = new RunnableThread();
		Thread mainThread = new Thread(th);
		mainThread.start();
		Runnable obj = ()->
		{
			try {
				for(int i=0;i<4;i++)
				{
					System.out.println("This is using Lambda EXpression");
					Thread.sleep(5000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		Thread secondThread = new Thread(obj);
		secondThread.start();
		for(int i =0 ; i<10;i++)
		{
			System.out.println("Main THread Execution at beep%+i");
			Thread.sleep(1000);
		}
		System.out.println("THe Main is Ended");
		
	}

}

class RunnableSecond implements Runnable {

	@Override
	public void run() {
		try {
			for (int i = 0; i < 15; i++) {
				System.out.print("\nThe Thread with Beep@" + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
class MyThreadClass extends Thread
{
	@Override
	public void run() 
	{
		synchronized (this) {
			RunnableThread th =  new RunnableThread();
			th.run();
			RunnableSecond th2 =  new RunnableSecond();
			th2.run();
		}
	}
	static void usingThreadClass()
	{
		MyThreadClass cls = new MyThreadClass();
		cls.start();
	}
}




