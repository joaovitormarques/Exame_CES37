
public class Dinner {

	public static void main(String[] args) throws InterruptedException {
		int[] table = new int[5];
		//Initialize the dinner's table
		for(int i=0; i<5; i++)
			table[i] = 1;
		
		//sit philosophers around the table
		Philosopher p1,p2,p3,p4,p5;
		p1 = new Philosopher(1, table);
		p2 = new Philosopher(2, table);
		p3 = new Philosopher(3, table);
		p4 = new Philosopher(4, table);
		p5 = new Philosopher(5, table);

		//Initialize the treads
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(p3);
		Thread t4 = new Thread(p4);
		Thread t5 = new Thread(p5);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		//Wait them terminate
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();
		
		System.out.println("All philosophers are done!");
	}

}
