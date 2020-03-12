import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Thread;

public class Scheduler implements Runnable {
	static Process process = null;
	static ReadyQueue a = new ReadyQueue();
	static int timer = 0;
	static int threadCount = 0;
	 static RoundRobinScheduling scheduler = new RoundRobinScheduling ();
	//@SuppressWarnings("deprecation")
	public static void main (String[] args) {
		

		createReadyQueue();
		//Thread thread = new Thread( new RoundRobinScheduling());

		//thread.start();
		while (a.firstProcess!=null){
			//thread.start();
		int [] arr = {a.firstProcess.process,a.firstProcess.time-1};
		timer ++;
		scheduler.roundRobinScheduler(timer,a.firstProcess);
		
		
		if (a.firstProcess.time == 0 ) {
			a.terminateProcess();
		}else {
		a.enqueue(arr,1);
		//a.priorityInsert(2,arr);
		a.terminateProcess();
		
		}
		
		}	
		
		System.out.print("THREADS: "+threadCount);
	}

	
		
	
class Schedule{
	void roundRobinScheduler () {
		a.firstProcess.time = a.firstProcess.time -1;
		System.out.println("Time "+timer+","+"Process "+a.firstProcess.process+","+" Resumed");
		timer++;
		System.out.println("Time "+timer+","+"Process "+ a.firstProcess.process+","+" paused");
		if(a.firstProcess.time == 0) {
		System.out.println("Time "+timer+","+"Process "+a.firstProcess.process+","+" finished");
		
		}
	}
	
		
	}
	static void createReadyQueue () {
		File file = new File("C:\\Users\\pirey\\Desktop\\test.txt"); //read a text file
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String st;
	
		try {
			
			while ((st = br.readLine()) != null) {
				String [] splitter = st.split(" ", 2);
				
			
					int processnum = Integer.parseInt(splitter[0]);
					int time = Integer.parseInt(splitter[1]);
					int [] arr = {processnum,time} ;
					
					a.enqueue(arr,0);
					
					
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
		System.out.println("Time "+timer+","+"Process "+a.firstProcess.process+","+" StartedREEEEEEE");
		threadCount++;
	}
}
	


	

