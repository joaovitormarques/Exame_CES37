import java.util.Random;

public class Philosopher implements Runnable{

	private boolean bellyIsFull = false;
	private int id;
	private int[] table;
	Random rand = new Random();
	
	//Constructor
	public Philosopher(int id, int[] table){
		this.setId(id);
		this.table = table;
	}
	
	//setter method
	private void setId(int id2) {
		this.id = id2;
	}
	
	//getter method
	private int getID() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	//wait some portion of time
	private void waitOp(){
		try {
			Thread.sleep(rand.nextInt(1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Here lies the Lehman and Rabin based algorithm
	//if the philosopher is hungry and the forks of both sides
	//are available, he eats and them returns the forks
	private void requestForks(int[] table2) {
		int id = this.getID();
		if(table2[id-1] == 1 && table2[id%5] == 1){
			//get the forks
			table2[id-1] = 0;
			table2[id%5] = 0;
			System.out.println("Philosopher "+this.getID()+" is eating.");
			//this.printTable();
			this.waitOp(); //eat
			this.bellyIsFull = true;
		}
		else this.waitOp();
		
	}
	
	//a debugger method to show the table
	private void printTable(){
		for(int i=0; i<5; i++)
			System.out.print(this.table[i] + " ");
		System.out.println();
	}
	
	//Philosopher actions
	@Override
	public void run() {
		System.out.println("Philosopher "+this.getID()+" is thinking.");
		//this.printTable();
		this.waitOp();
		System.out.println("Philosopher "+this.getID()+" is hungry.");
		//this.printTable();
		while(!this.bellyIsFull ){
			this.requestForks(this.table);
		}
		System.out.println("Philosopher "+this.getID()+" is full!");
		//return the forks
		this.table[this.getID()-1] = 1;
		this.table[this.getID()%5] = 1;
		//this.printTable();
	}
}
