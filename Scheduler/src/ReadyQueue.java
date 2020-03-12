
public class ReadyQueue {
	
	Process firstProcess;
	
	public void enqueue (int [] arr) {
		Process process = new Process();
		process.process = arr[0];
		process.time = arr[1];
		process.nextProcess = null;
		if (firstProcess == null) {
			firstProcess = process;
		}else {
			Process p = firstProcess;
			while (p.nextProcess!=null) {
				p = p.nextProcess;
			}
			p.nextProcess = process;
			
		}
	}
	//Process currentPocess (){
	//	return firstProcess;
	//}
	public void showReadyQueue() {
		Process process = firstProcess;
		while(process.nextProcess!=null) {
			System.out.println("Process: "+process.process+" "+process.time);
			process = process.nextProcess;
		}
		System.out.println("Process: "+process.process+" "+process.time);

	}
	
	void priorityInsert(int index,int[]arr){
		Process process = new Process();
		process.process = arr[0];
		process.time = arr[1];
		process.nextProcess = null;
		Process p = firstProcess;
		for (int i =0;i<index-1;i++) {
			p=p.nextProcess;
		}
		process.nextProcess = p.nextProcess;
		p.nextProcess = process;
	}
	void terminateProcess() {
		
	
			firstProcess = firstProcess.nextProcess;
		
	
		
	}
	
	

}
