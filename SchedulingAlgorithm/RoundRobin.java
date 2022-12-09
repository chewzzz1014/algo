import java.util.Scanner;

public class RoundRobin {
	
	public static void main (String[]args) {
		Scanner sc = new Scanner(System.in);
		String allCode = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String ganttChart = "";
		int numProcess, burstTime, timeQuantum, 
			currentTime = 0, totalTA=0, totalWait = 0;
		int[]allBurstTime;
		Queue allProcess;
		Queue pendingProcess = new Queue(25);
		
		// get all users input
		System.out.print("N: ");
		numProcess = sc.nextInt();
		allProcess = new Queue(numProcess);
		
		System.out.print("\nBurst time: ");
		allBurstTime = new int[numProcess];
		for (int i=0; i<numProcess; i++) {
			burstTime = sc.nextInt();
			allBurstTime[i] = burstTime;
			RoundRobinProcess r = new RoundRobinProcess(allCode.charAt(i)+"",0, allBurstTime[i]);
			
			allProcess.enqueue(r);
			pendingProcess.enqueue(r);
		}
		
		System.out.print("\nQ: ");
		timeQuantum = sc.nextInt();	
		
		while(pendingProcess.size() > 0) {
			RoundRobinProcess r = (RoundRobinProcess) pendingProcess.dequeue();
			
			if (r.burstTime>timeQuantum) {
				for (int i=0; i<timeQuantum; i++) 
					ganttChart += r.code;
				
				r.slices.add(currentTime);
				r.burstTime -= timeQuantum;
				currentTime += timeQuantum;
				
				pendingProcess.enqueue(r);
			}else {
				for (int i=0; i<r.burstTime; i++) 
					ganttChart += r.code;
				
				r.slices.add(currentTime);
				currentTime += r.burstTime;
				r.burstTime = 0;
				
				r.completeTime = currentTime;
				r.turnAroundTime = r.completeTime - r.arrivalTime;
				r.waitTime = r.turnAroundTime - r.fixedBurst;
				
				totalTA += r.turnAroundTime;
				totalWait += r.waitTime;
			}
			sc.close();
		}
		
		
		System.out.println("\nProcess\tArrival\tBurst\t Exec. slices (t) \tComplete\tTurnaround\tWaiting");
		System.out.println(allProcess.toString());
		System.out.println("Gantt chart (1 char = 1 microsecond): ");
		System.out.println(ganttChart);
		System.out.println();
		System.out.printf("Average Waiting Time for %1d Processes: %.2f units\n", numProcess, ((double)totalWait/numProcess));
		System.out.printf("Average Turn Around Time for %1d Processes: %.2f units\n", numProcess, ((double)totalTA/numProcess));
	}
	
}
