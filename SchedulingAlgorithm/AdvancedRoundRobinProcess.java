import java.util.ArrayList;

public class AdvancedRoundRobinProcess extends Process{
	
	public ArrayList<Integer> slices = new ArrayList<Integer>();
	int fixedBurst;
	
	public AdvancedRoundRobinProcess(String code, int arrivalTime, int burstTime){
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
		
		
		return String.format("%-9s %-21s %-15s %-15s %-15s %-5s\n",
				code, slicesStr, completeTime+"", turnAroundTime+"", waitTime+"", fixedBurst);
	}
	
}
