
public class requestQueueBuilder {
	
	
	
	public Process getNewProcess (int array[]) {
		
		Process newProcess = new Process();
		newProcess.process = array[0];
		newProcess.time = array[1];
		newProcess.nextProcess = null;
		return newProcess;
	}

	
	public Process append (int [] arr,Process process) {
		if(process==null) {
			return getNewProcess(arr);
		}
			process.nextProcess = append (arr,process.nextProcess);	
			return process;
		
	}
	public Process terminateProcess(Process process) {
		if (process == null) {
			return null;
		}
		Process temp = process;
		Process previous;
		if (temp != null ) {
		return process = temp.nextProcess;
		}else return null;
	}

	public void printList(Process process) {
	
		if (process == null) {
			return;
		}
		System.out.print("Process #"+process.process+"  "+process.time+"\n");
		
		printList(process.nextProcess);
		
		
	}
	int SMOLTIME = 1000000;
	public Process nextProcessToExecute (Process process) {
		Process nextprocess = null;
		if (process.nextProcess != null) {
		if (process.time < SMOLTIME) {
			SMOLTIME = process.time;
			nextProcessToExecute(process.nextProcess);
			nextprocess = process;
		}
		}
		return nextprocess;
		
		
	}
	
	

}
