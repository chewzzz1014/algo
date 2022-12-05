import java.util.ArrayList;

public class RoundRobinProcess extends Process{
	
	public ArrayList<Integer> slices = new ArrayList<Integer>();
	
	public RoundRobinProcess(String code, int arrivalTime, int burstTime){
		super(code, arrivalTime, burstTime);
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
		
		
		return String.format("%-9s %-21s %-15s %-15s %-15s\n",
				code, slicesStr, completeTime+"", turnAroundTime+"", waitTime+"");
	}
	
}
