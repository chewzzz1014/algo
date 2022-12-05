public class FCFSScheduling {
	public static void main (String[]args) {
		
		// Queue
		Queue FCFCQueue = new Queue(5);
		int currentTime = 0,
			totalTurnAroundTime = 0,
			totalWaitTime = 0,
			numProcess = 0;
		
		FCFCQueue.enqueue(new Process("A", 0, 6));
		FCFCQueue.enqueue(new Process("B", 2, 4));
		FCFCQueue.enqueue(new Process("C", 5, 1));
		FCFCQueue.enqueue(new Process("D", 6, 3));
		FCFCQueue.enqueue(new Process("E", 	9, 5));
		numProcess = FCFCQueue.size();
		
		System.out.println("Process\tArrival\tBurst\tComplete\tTurnaround\tWaiting");
		for (int i=0; i<numProcess; i++) {
			Process currentProcess = (Process) FCFCQueue.dequeue();
			currentTime += currentProcess.burstTime;
			currentProcess.completeTime = currentTime;
			currentProcess.turnAroundTime = currentProcess.completeTime - currentProcess.arrivalTime;
			currentProcess.waitTime = currentProcess.turnAroundTime - currentProcess.burstTime;
			
			totalTurnAroundTime += currentProcess.turnAroundTime;
			totalWaitTime += currentProcess.waitTime;
			System.out.print(currentProcess.toString());;
		}
		
		System.out.println(FCFCQueue.toString());
		System.out.printf("Average Turn Around Time: %.2f units\n", ((double)totalTurnAroundTime/numProcess));
		System.out.printf("Average Waiting Time: %.2f units\n", ((double)totalWaitTime/numProcess));
	}
}
