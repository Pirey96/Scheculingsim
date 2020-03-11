import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Scheduler implements Runnable {
	static Process process = null;
	static requestQueueBuilder a = new requestQueueBuilder();
	static int nextProcessToExecute = 100000;
	public static void main (String[] args) {
		
		createReadyQueue();
		
		RoundRobinMethod currentProcess = new RoundRobinMethod();
		int timer = 1;
		
		//while (process!=null) {	
		for(int i = 0;i<10;i++) {
			
			if(process.time==0) {
				System.out.println("Time "+timer+","+"Process "+process.process+","+" finished");
				process = a.nextProcessToExecute(process);
			}else {
		currentProcess.executeCurrentProcess(process,timer);
		int [] arr = {process.process,process.time};
		timer ++;
		System.out.println("Time "+timer+","+"Process "+ process.process+","+" paused");
		process = a.append(arr, process);
		a.terminateProcess(process);
		
		process = a.nextProcessToExecute(process);
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
					
					process = a.append(arr, process);
					
					
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
	


	

