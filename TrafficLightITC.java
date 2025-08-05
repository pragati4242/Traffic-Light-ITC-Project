package Thread;

public class TrafficLightITC {
 
	public static void main(String []args) throws InterruptedException
	{
		Object lock =new Object();
		
		Thread green= new Thread(()->
		{
			synchronized(lock)
			{
				try {
					System.out.println("Green Light: Waiting for red light signal!");
					lock.wait();
					System.out.println("Green Light: GO!!!!");
				}catch(InterruptedException e)
				{
					
				}
			}
		});

		
		Thread red = new Thread(()->
		{
			System.out.println("Traffic CountDown start");
			for(int i=0; i<10; i++)
			{
				System.out.println(i);
				try {
				Thread.sleep(1000);
				}catch(InterruptedException e) {}
			}
			
			synchronized(lock)
			{
			System.out.println("Traffic relesed!!!");
			lock.notify();
			}
		});
		

	
	green.start();
	Thread.sleep(1000);
	red.start();
	
	
	}
}
