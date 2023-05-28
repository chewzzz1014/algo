import java.util.ArrayList;
import java.io.IOException;

public class MainKnapsack {
	public static void main (String [] args) throws IOException{
			final int AIRLINE_LIMIT = 7000;
			final String FILE_PATH_BASE = "C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_Knapsack";
			
			Knapsack ks = new Knapsack(AIRLINE_LIMIT);
		 	ArrayList<Item> items = ks.readItemsFromCSV(FILE_PATH_BASE + "\\items.csv");
			 	
		 	// greedy algorithm
		 	System.out.print("----Greedy Algorithm\n----");
	        GreedyKnapsack gk = new GreedyKnapsack(AIRLINE_LIMIT);
	        
	        long start1 = System.nanoTime();
	        ArrayList<Item> result1 = gk.solveKnapsack(items);
	        long end1 = System.nanoTime();
	        
	        gk.printResult(result1);
	        gk.writeToFile(result1, FILE_PATH_BASE + "\\greedy_results.csv");
	        System.out.println("Total Execution Time: " + gk.calcExecutionTime(start1, end1) + " ms");
	        
	        
	        
	        System.out.println();
	        
	        
	        
	        // dynamic programming
	        System.out.print("----Dynamic Programming----\n");
		 	DynamicKnapsack dk = new DynamicKnapsack(AIRLINE_LIMIT);
		 	
		 	long start2 = System.nanoTime();
	        ArrayList<Item> result2 = dk.solveKnapsack(items);
	        long end2 = System.nanoTime();
	        
	        dk.printResult(result2);
	        dk.writeToFile(result2, FILE_PATH_BASE + "\\dynamic_results.csv");
	        System.out.println("Total Execution Time: " + gk.calcExecutionTime(start2, end2) + " ms");
	}
}
