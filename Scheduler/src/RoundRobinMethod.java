public class RoundRobinMethod {


	
	public Process executeCurrentProcess(Process process,int timer) {
		System.out.println("Time "+timer+","+"Process "+process.process+","+" Started");
		System.out.println("Time "+timer+","+"Process "+process.process+","+" Resumed");
		process.time = process.time - 1;
		return process;
}
	}
