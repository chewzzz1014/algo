import java.util.*;

public class AdvancedRoundRobin {
	
	public static void main (String[]args) {
		Scanner sc = new Scanner(System.in);
		String allCode = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String ganttChart = "";
		int numProcess, burstTime, timeQuantum, 
			currentTime = 0, totalTA=0, totalWait = 0;
		int[]allBurstTime, allArrivalTime;
		Queue allProcess;
		Queue pendingProcess = new Queue(25);
		Map<Integer, RoundRobinProcess> map = new HashMap<>();
		
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
			RoundRobinProcess r = new RoundRobinProcess(allCode.charAt(i)+"",allArrivalTime[i], allBurstTime[i]);
			
			allProcess.enqueue(r);
			map.put(r.arrivalTime, r);
			
			//pendingProcess.enqueue(r);
		}
		
		System.out.print("\nQ: ");
		timeQuantum = sc.nextInt();	
		
		// sort all processes by arrival time
		TreeMap<Integer, RoundRobinProcess> treeMap = new TreeMap<>(map);
		
		// record all processes arrival time
		Integer[] sortedAllArrivalTime = treeMap.keySet().toArray(new Integer[treeMap.size()]);
		
		// add first process (that reached earliest) to the pending queue
		RoundRobinProcess currentProcess = treeMap.firstEntry().getValue();
		pendingProcess.enqueue(currentProcess);
		
		// start from first process
		currentTime = currentProcess.arrivalTime;
		int currentIdx = 0;
		
		boolean hasNextProcess;
		int numProcessFromCurrent;
		while(pendingProcess.size() > 0 || currentIdx<numProcess) {
			hasNextProcess = true;
			numProcessFromCurrent = 1;
			
			if (currentProcess.burstTime <= timeQuantum) {
				for (int i=0; i<currentProcess.burstTime; i++) 
					ganttChart += currentProcess.code;
				
				currentProcess.slices.add(currentTime);
				currentTime += currentProcess.burstTime;
				currentProcess.burstTime = 0;
				
				currentProcess.completeTime = currentTime;
				currentProcess.turnAroundTime = currentProcess.completeTime - currentProcess.arrivalTime;
				currentProcess.waitTime = currentProcess.turnAroundTime - currentProcess.fixedBurst;
				
				totalTA += currentProcess.turnAroundTime;
				totalWait += currentProcess.waitTime;
				
				while(hasNextProcess) {
					if (((currentIdx+numProcessFromCurrent)<sortedAllArrivalTime.length) &&sortedAllArrivalTime[currentIdx+numProcessFromCurrent]<= currentTime) {
						pendingProcess.enqueue(treeMap.get(sortedAllArrivalTime[currentIdx+numProcessFromCurrent]));
						numProcessFromCurrent++;
					}
					else
						{hasNextProcess = false;}			
				}
			}else {
				
				for (int i=0; i<timeQuantum; i++) 
					ganttChart += currentProcess.code;
				
				currentProcess.slices.add(currentTime);
				currentProcess.burstTime -= timeQuantum;
				currentTime += timeQuantum;
				
				while(hasNextProcess) {
					if (((currentIdx+numProcessFromCurrent)<sortedAllArrivalTime.length) &&sortedAllArrivalTime[currentIdx+numProcessFromCurrent]<= currentTime) {
						pendingProcess.enqueue(treeMap.get(sortedAllArrivalTime[currentIdx+numProcessFromCurrent]));
						numProcessFromCurrent++;
					}
					else
						{hasNextProcess = false;}
				}
				
				pendingProcess.enqueue(currentProcess);
			}
			
			System.out.println(pendingProcess.toString());
			currentIdx++;
			if (currentIdx == 1) {
				pendingProcess.dequeue();
				currentProcess = (RoundRobinProcess)pendingProcess.dequeue();
			}
			else if (currentIdx>0) {
				currentProcess = (RoundRobinProcess)pendingProcess.dequeue();
			}
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
