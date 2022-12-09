// Chew Zi Qing 212360

import java.util.Scanner;
public class RoundRobin {
	
	public static void main (String[]args) {
		// initialize statistics
		Scanner sc = new Scanner(System.in);
		String allCode = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String ganttChart = "";
		int numProcess, burstTime, timeQuantum, 
			currentTime = 0, totalTA=0, totalWait = 0;
		int[]allBurstTime;
		// 2 queues: queue that stores all process (fixed) and process execution queue
		Queue allProcess;
		Queue pendingProcess = new Queue(25);
		
		// get number of processes
		System.out.print("N: ");
		numProcess = sc.nextInt();
		allProcess = new Queue(numProcess);
		
		// get burst time for all processes
		// create RoundRobinProcess and store it in queues
		System.out.print("\nBurst time: ");
		allBurstTime = new int[numProcess];
		for (int i=0; i<numProcess; i++) {
			burstTime = sc.nextInt();
			allBurstTime[i] = burstTime;
			RoundRobinProcess r = new RoundRobinProcess(allCode.charAt(i)+"",0, allBurstTime[i]);
			
			allProcess.enqueue(r);
			pendingProcess.enqueue(r);
		}
		
		// get time quantum
		System.out.print("\nQ: ");
		timeQuantum = sc.nextInt();	
		
		// round robin algorithm
		// repeat till the FIFO queue is empty (all processes are completed)
		while(pendingProcess.size() > 0) {
			RoundRobinProcess r = (RoundRobinProcess) pendingProcess.dequeue();
			
			// burst time of process > time quantum
			// deduct the burst time and add the process to end of queue
			if (r.burstTime>timeQuantum) {
				for (int i=0; i<timeQuantum; i++) 
					ganttChart += r.code;
				
				r.slices.add(currentTime);
				r.burstTime -= timeQuantum;
				currentTime += timeQuantum;
				
				pendingProcess.enqueue(r);
			}else {
				// process's burst time <= time quantum
				// process is completed (not adding it to queue)
				
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
		
		// output the statistics for each process, Gantt chart, average turn around time and waiting time
		System.out.println("\nProcess\tArrival\tBurst\t Exec. slices (t) \tComplete\tTurnaround\tWaiting");
		System.out.println(allProcess.toString());
		System.out.println("Gantt chart (1 char = 1 microsecond): ");
		System.out.println(ganttChart);
		System.out.println();
		System.out.printf("Average Waiting Time for %1d Processes: %.2f ms\n", numProcess, ((double)totalWait/numProcess));
		System.out.printf("Average Turn Around Time for %1d Processes: %.2f ms\n", numProcess, ((double)totalTA/numProcess));
	}
	
}
