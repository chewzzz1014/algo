
public class Process {
	String code;
	int arrivalTime, burstTime, 
	completeTime, waitTime, turnAroundTime;
	
	public Process(String code, int arrivalTime, int burstTime) {
		this.code = code;
		this.arrivalTime = arrivalTime;
		this.burstTime = burstTime;
	}
	
	public String toString() {
		return code + "\t" + arrivalTime + "\t" +
				burstTime + "\t" + completeTime + "\t\t" +
				turnAroundTime + "\t\t" + waitTime + "\n";
	}
}
