
public class FCFSScheduling {
	public static void main (String[]args) {
		
		Queue FCFCQueue = new Queue(5);
		int currentTime = 0;
		
		FCFCQueue.enqueue(new Process("A", 0, 6));
		FCFCQueue.enqueue(new Process("B", 2, 4));
		FCFCQueue.enqueue(new Process("C", 5, 1));
		FCFCQueue.enqueue(new Process("D", 6, 3));
		FCFCQueue.enqueue(new Process("E", 	9, 5));
		
		for (int i=0; i<FCFCQueue.size(); i++) {
			Process currentProcess = (Process) FCFCQueue.getItem(i);
			currentTime += currentProcess.burstTime;
			currentProcess.completeTime = currentTime;
			currentProcess.turnAroundTime = currentProcess.completeTime - currentProcess.arrivalTime;
			currentProcess.waitTime = currentProcess.turnAroundTime - currentProcess.burstTime;
			//FCFCQueue.dequeue();
		}
		
		System.out.println("Process\tArrival\tBurst\tComplete\tTurnaround\tWaiting");
		System.out.println(FCFCQueue.toString());
		
	}
}
