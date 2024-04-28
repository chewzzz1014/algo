// Chew Zi Qing 212360

// implementing First Come First Serve scheduling algorithm

import Queue.Queue;

public class FCFSScheduling {
	public static void main (String[]args) {
		
		// processes' FIFO queue
		Queue FCFCQueue = new Queue(5);
		// initialize statistics
		int currentTime = 0,
			totalTurnAroundTime = 0,
			totalWaitTime = 0,
			numProcess = 0;
		
		// add 5 processes to the queue
		FCFCQueue.enqueue(new Process("A", 0, 6));
		FCFCQueue.enqueue(new Process("B", 2, 4));
		FCFCQueue.enqueue(new Process("C", 5, 1));
		FCFCQueue.enqueue(new Process("D", 6, 3));
		FCFCQueue.enqueue(new Process("E", 	9, 5));
		numProcess = FCFCQueue.size();
		
		// calculate complete time, turn around time and waiting time for each process
		// print statistics for each process
		System.out.println("Process\tArrival\tBurst\tComplete\tTurnaround\tWaiting");
		for (int i=0; i<numProcess; i++) {
			Process currentProcess = (Process) FCFCQueue.dequeue();
			currentTime += currentProcess.burstTime;
			currentProcess.completeTime = currentTime;
			currentProcess.turnAroundTime = currentProcess.completeTime - currentProcess.arrivalTime;
			currentProcess.waitTime = currentProcess.turnAroundTime - currentProcess.burstTime;
			
			totalTurnAroundTime += currentProcess.turnAroundTime;
			totalWaitTime += currentProcess.waitTime;
			System.out.print(currentProcess.toString());
		}
		
		// output the average turn around time and waiting time
		System.out.println();
		System.out.printf("Average Turn Around Time: %.2f units\n", ((double)totalTurnAroundTime/numProcess));
		System.out.printf("Average Waiting Time: %.2f units\n", ((double)totalWaitTime/numProcess));
	}
}
