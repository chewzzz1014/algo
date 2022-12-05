import java.util.ArrayList;

public class AdvancedRoundRobinProcess extends Process{
	
	public ArrayList<Integer> slices = new ArrayList<Integer>();
	int fixedBurst;
	
	public AdvancedRoundRobinProcess(String code, int arrivalTime, int burstTime){
		super(code, arrivalTime, burstTime);
		fixedBurst = burstTime;
		slices.add(1);
		slices.add(2);
		slices.add(3);
	}
	
	@Override
	public String toString() {
		String slicesStr = "";
		for (int i=0; i<slices.size(); i++) {
			slicesStr += slices.get(i);
			if (i<slices.size()-1)
				{slicesStr += ", ";}
		}
		
//		\nProcess\tArrival\tBurst\t Exec. slices (t) \tComplete\tTurnaround\tWaiting
		return String.format("%-7s %-8s %-7s %-22s %-15s %-15s %-15s\n",
				code, arrivalTime+"", fixedBurst+"" ,slicesStr, completeTime+"", turnAroundTime+"", waitTime+"");
	}
	
}
