// Chew Zi Qing 212360
import java.util.ArrayList;

// inherit from Process class
public class RoundRobinProcess extends Process{
	// to store all start time of a process
	public ArrayList<Integer> slices = new ArrayList<Integer>();
	int fixedBurst;
	
	public RoundRobinProcess(String code, int arrivalTime, int burstTime){
		super(code, arrivalTime, burstTime);
		fixedBurst = burstTime;
	}
	
	@Override
	public String toString() {
		String slicesStr = "";
		for (int i=0; i<slices.size(); i++) {
			slicesStr += slices.get(i);
			if (i<slices.size()-1)
				{slicesStr += ", ";}
		}
		
		return String.format("%-7s %-8s %-7s %-22s %-15s %-15s %-15s\n",
				code, arrivalTime+"", fixedBurst+"" ,slicesStr, completeTime+"", 
				turnAroundTime+"", waitTime+"");
	}
	
}
