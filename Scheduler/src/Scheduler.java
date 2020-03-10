import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Scheduler implements Runnable {
	static int [] array =new int [10];
	public static void main (String[] args) {
		read();
		for (int i=0;i<array.length;i++) {
			System.out.print(array[i] + " ");
		}
		
		
		Process process = null;
		requestQueueBuilder a = new requestQueueBuilder();
		
		
		a.printList(process);
	}
		
	
		
	
	static void read () {
		File file = new File("C:\\Users\\pirey\\Desktop\\test.txt"); //read a text file
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String st;
	
		
		int j = 0;
		try {
			while ((st = br.readLine()) != null) {
				String [] splitter = st.split(" ", 2);
				for (String finalString : splitter) {
				int i = Integer.parseInt(finalString);
				array[j++]=i;
				
				}
			}
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
	


	

