import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Thread;

public class Scheduler implements Runnable {
	static Process process = null;
	static ReadyQueue a = new ReadyQueue();
	static int timer = 1;
	static int threadCount = 0;
	static Schedule sched = new Schedule();


	@SuppressWarnings("deprecation")
	public static void main (String[] args) {
		

		createReadyQueue();
		

		//thread.start();
		while (a.firstProcess!=null){
		Thread thread = new Thread(new Scheduler());

		thread.start();
		int [] arr = {a.firstProcess.process,a.firstProcess.time-1};
		sched.roundRobinScheduler();

		
		if (a.firstProcess.time == 0 ) {
			a.terminateProcess();
		}else {
		a.enqueue(arr,1);
		//a.priorityInsert(2,arr);
		a.terminateProcess();
		
		}
		
		
		
		}	
	}

	
		
	
static class Schedule implements Runnable{
	void roundRobinScheduler () {
		Thread thread = new Thread(new Schedule());
		thread.start();
		//System.out.println("SABRINA");
		//thread.resume();
		//thread.suspend();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		a.firstProcess.time = a.firstProcess.time -1;
		System.out.println("Time "+timer+","+"Process "+a.firstProcess.process+","+" Resumed");
		timer++;
		System.out.println("Time "+timer+","+"Process "+ a.firstProcess.process+","+" paused");
		if(a.firstProcess.time == 0) {
		System.out.println("Time "+timer+","+"Process "+a.firstProcess.process+","+" finished");
		threadCount++;

		
	}
	
		
	}
}
	static void createReadyQueue () {
		File file = new File("C:\\Users\\pirey\\Desktop\\test.txt"); //read a text file
		BufferedReader br = null;
		try {                                                            //
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String st;
		Schedule schedule = new Schedule();
		try {
			
			while ((st = br.readLine()) != null) {
				String [] splitter = st.split(" ", 2);
					int processnum = Integer.parseInt(splitter[0]);
					int time = Integer.parseInt(splitter[1]);
					int [] arr = {processnum,time} ;
					a.enqueue(arr,0);
					//schedule.

			}
			//a.printList(process);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		
		threadCount++;
		
	}
}
	


	

