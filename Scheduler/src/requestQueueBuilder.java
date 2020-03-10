
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


	public void printList(Process process) {
	
		if (process == null) {
			return;
		}
		System.out.print(process.process+"  "+process.time+"\n");
		
		printList(process.nextProcess);
		
		
	}
	
	
	
	
	

}
