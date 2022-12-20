/*
 * Create a Java program which calculates the factorial for 5 numbers (values ranging from 1 to 10) specified by user. 
E.g.
	Enter 5 numbers [1-10]: 10 3 6 7 4

	The factorials for 10 3 6 7 4 are 3628800 6 720 5040 24

You must use multithreading to perform the processing, by creating a thread to calculate the factorial for each number given. The threads may store all the results into a single array. Then print out the results after all results has been calculated and stored inside the array (You may also use other data structure other than array if it is more suitable). 
 */
public class ConcurrentProcessing extends Thread {
	long[] allResults = new long[5];
	
	public static void main (String[]args) {
		CountFactorial cf = new CountFactorial(0, 3);
		Thread t = new Thread(cf);
		t.start();
	}
	
	class CountFactorial implements Runnable{
		public int idx, value;
		long result=1;
		
		public CountFactorial(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}
		
		public void run() {
			for(int i=1; i<=value; i++) {
				result *= i;
			}
			System.out.println("Result is "+result);
			allResults[idx] = result;
		}
	}

}

