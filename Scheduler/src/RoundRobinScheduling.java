
public class RoundRobinScheduling {
	
	static void roundRobinScheduler (int timer,Process process) {
		
		
		
		System.out.println("Time "+timer+","+"Process "+process.process+","+" Resumed");
		
		System.out.println("Time "+timer+","+"Process "+ process.process+","+" paused");
		if(process.time == 0) {
		System.out.println("Time "+timer+","+"Process "+process.process+","+" finished");
		
		}

}
}