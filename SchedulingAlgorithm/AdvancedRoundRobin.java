import java.util.Scanner;

public class AdvancedRoundRobin {
	
	public static void main (String[]args) {
		Scanner sc = new Scanner(System.in);
		String allCode = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int numProcess, burstTime, timeQuantum, 
			currentTime = 0, totalTA=0, totalWait = 0;
		int[]allBurstTime, allArrivalTime;
		Queue allProcess;
		Queue pendingProcess = new Queue(25);
		
		// get all users input
		System.out.print("N: ");
		numProcess = sc.nextInt();
		allProcess = new Queue(numProcess);
		
		System.out.print("\nArrival time: ");
		allArrivalTime = new int[numProcess];
		for (int i=0; i<numProcess; i++) {
			allArrivalTime[i] = sc.nextInt();
		}
		
		System.out.print("\nBurst time: ");
		allBurstTime = new int[numProcess];
		for (int i=0; i<numProcess; i++) {
			burstTime = sc.nextInt();
			allBurstTime[i] = burstTime;
			AdvancedRoundRobinProcess r = new AdvancedRoundRobinProcess(allCode.charAt(i)+"",allArrivalTime[i], allBurstTime[i]);
			
			allProcess.enqueue(r);
			pendingProcess.enqueue(r);
		}
		
		System.out.print("\nQ: ");
		timeQuantum = sc.nextInt();	
		
		while(pendingProcess.size() > 0) {
			AdvancedRoundRobinProcess r = (AdvancedRoundRobinProcess) pendingProcess.dequeue();
			
			if (r.burstTime>timeQuantum) {
				r.slices.add(currentTime);
				r.burstTime -= timeQuantum;
				currentTime += timeQuantum;
				
				pendingProcess.enqueue(r);
			}else {
				r.slices.add(currentTime);
				currentTime += r.burstTime;
				r.burstTime = 0;
				
				r.completeTime = currentTime;
				r.turnAroundTime = r.completeTime - r.arrivalTime;
				r.waitTime = r.turnAroundTime - r.fixedBurst;
				
				totalTA += r.turnAroundTime;
				totalWait += r.waitTime;
			}
		}
		
		
		System.out.println("\nProcess\tArrival\tBurst\t Exec. slices (t) \tComplete\tTurnaround\tWaiting");
		System.out.println(allProcess.toString());
		System.out.printf("Average Waiting Time for %1d Processes: %.2f units\n", numProcess, ((double)totalWait/numProcess));
		System.out.printf("Average Turn Around Time for %1d Processes: %.2f units\n", numProcess, ((double)totalTA/numProcess));
	}
	
}
