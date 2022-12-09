// Chew Zi Qing

// store all properties of process
public class Process {
	String code;
	int arrivalTime, burstTime, 
	completeTime, waitTime, turnAroundTime;
	
	// constructor that assigns name, arrival time and burst time of process
	// other properties are given a default value of 0, and will be calculated in main program
	public Process(String code, int arrivalTime, int burstTime) {
		this.code = code;
		this.arrivalTime = arrivalTime;
		this.burstTime = burstTime;
	}
	
	// return all properties of process in a single line
	public String toString() {
		return code + "\t" + arrivalTime + "\t" +
				burstTime + "\t" + completeTime + "\t\t" +
				turnAroundTime + "\t\t" + waitTime + "\n";
	}
}
