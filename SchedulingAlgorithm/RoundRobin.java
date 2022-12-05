import java.util.Scanner;

public class RoundRobin {
	
	public static void main (String[]args) {
		Scanner sc = new Scanner(System.in);
		int numProcess, burstTime, timeQuantum;
		int[]allBurstTime;
		
		// get all users input
		System.out.print("N: ");
		numProcess = sc.nextInt();
		System.out.print("\nBurst time: ");
		allBurstTime = new int[numProcess];
		for (int i=0; i<numProcess; i++) {
			burstTime = sc.nextInt();
			allBurstTime[i] = burstTime;
		}
		System.out.print("\nQ: ");
		timeQuantum = sc.nextInt();
		
		Queue processQueue = formProcessQueue(numProcess, allBurstTime, timeQuantum);
		System.out.println("\nProcess\t  Exec. slices (t) \tComplete\tTurnaround\tWaiting");
		System.out.println(processQueue.toString());
	}
	
	public static Queue formProcessQueue(int numProcess, int[] allBurstTime,int  timeQuantum) {
		String allCode = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Queue q = new Queue(numProcess);
		
		for (int i=0; i<numProcess; i++) {
			q.enqueue(new RoundRobinProcess(allCode.charAt(i)+"",0, allBurstTime[i]));
		}
		return q;
	}
}
