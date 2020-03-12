import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Scheduler implements Runnable {
	static Process process = null;
	static ReadyQueue a = new ReadyQueue();
	static RoundRobinMethod p = new RoundRobinMethod();
	//static int nextProcessToExecute = 100000;
	public static void main (String[] args) {
		
		createReadyQueue();
		//a.showReadyQueue();
		int timer = 0;
		while (a.firstProcess!=null){
		int [] arr = {a.firstProcess.process,a.firstProcess.time-1};
		//p.executeCurrentProcess(a.firstProcess, timer++);
		timer++;
		roundRobinScheduler(timer);
		a.firstProcess.status = 1;
		if (a.firstProcess.time == 0 ) {
			a.terminateProcess();
		}else {
			
		a.enqueue(arr);
		a.terminateProcess();
		//a.showReadyQueue();
		//System.out.println();
		}
		
		}			
	}
	static void roundRobinScheduler (int timer) {
		a.firstProcess.time = a.firstProcess.time -1;
		if( a.firstProcess.status == 0) {
			System.out.println("Time "+timer+","+"Process "+a.firstProcess.process+","+" Started");

		}
		
		System.out.println("Time "+timer+","+"Process "+a.firstProcess.process+","+" Resumed");
		
		System.out.println("Time "+timer+","+"Process "+ a.firstProcess.process+","+" paused");
		if(a.firstProcess.time == 0 && a.firstProcess.nextProcess!=null) {
		System.out.println("Time "+timer+","+"Process "+a.firstProcess.process+","+" finished");
		
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
					
					a.enqueue(arr);
					
					
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
		
	}
}
	


	

