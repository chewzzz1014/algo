// Chew Zi Qing 212360
import java.util.*;
public class ConcurrentProcessing extends Thread {
	// to store user inputs, factorials and thread
	static int[] allInputs = new int[5];
	static long[] allResults = new long[5];
	static Thread[] allThreads = new Thread[5];
	
	public static void main (String[]args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		
		// read input and store thread in array
		System.out.print("Enter 5 numbers [1-10]: ");
		for(int i=0; i<5; i++) {
			allInputs[i] = sc.nextInt();
			allThreads[i] = new Thread(new CountFactorial(i, allInputs[i]));
		}
		
		// start all thread
		for(Thread t: allThreads)
			t.start();
		
		// ensure that all thread are completed before proceed with output
		for(Thread t: allThreads)
			t.join();
		
		// exclude [ ] and comma in Arrays.toString()
		String allInputsDisplay = String.join(" ", Arrays.toString(allInputs)
										.substring(1, Arrays.toString(allInputs)
										.length()-1)
										.split(", "));
		String allResultsDisplay = String.join(" ", Arrays.toString(allResults)
										.substring(1, Arrays.toString(allResults)
										.length()-1)
										.split(", "));
		
		System.out.print("\nThe factorials for "
						 + allInputsDisplay + " are "+allResultsDisplay);
		sc.close();
	}
	
	// class that calculates factorial
	static class CountFactorial implements Runnable{
		public int idx, value;
		long result=1;
		
		public CountFactorial(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}
		
		// will run this when thread is started
		// store result to results array
		public void run() {
			for(int i=1; i<=value; i++) {
				result *= i;
			}
			allResults[idx] = result;
		}
	}

}

