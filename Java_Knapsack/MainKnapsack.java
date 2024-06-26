// Chew Zi Qing
import java.util.ArrayList;
import java.io.IOException;

// Main program
public class MainKnapsack {
	public static void main (String [] args) throws IOException{
			// define airline weight limit
			final int AIRLINE_LIMIT = 4000;
			final String FILE_PATH_BASE = "C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_Knapsack";
			
			// read list of items from items.csv
			Knapsack ks = new Knapsack(AIRLINE_LIMIT);
		 	ArrayList<Item> items = ks.readItemsFromCSV(FILE_PATH_BASE + "\\items.csv");
			 	
		 	// greedy algorithm
		 	System.out.print("----Greedy Algorithm----\n");
	        GreedyKnapsack gk = new GreedyKnapsack(AIRLINE_LIMIT);
	        
	        // calc execution time for greedy algorithm
	        long start1 = System.nanoTime();
	        ArrayList<Item> result1 = gk.solveKnapsack(items);
	        long end1 = System.nanoTime();
	        
	        // print result and save optimal solution for greedy algorithm
	        gk.printResult(result1);
	        gk.writeToFile(result1, FILE_PATH_BASE + "\\greedy_results.csv");
	        System.out.println("Total Execution Time: " + gk.calcExecutionTime(start1, end1) + " ms");
	        
	          
	        System.out.println();
	        
	        
	        // calc execution time for dynamic prog
	        System.out.print("----Dynamic Programming----\n");
		 	DynamicKnapsack dk = new DynamicKnapsack(AIRLINE_LIMIT);
		 	
		 	// calc execution time for dynamic prog
		 	long start2 = System.nanoTime();
	        ArrayList<Item> result2 = dk.solveKnapsack(items);
	        long end2 = System.nanoTime();
	        
	        // print result and save optimal solution for dynamic algorithm
	        dk.printResult(result2);
	        dk.writeToFile(result2, FILE_PATH_BASE + "\\dynamic_results.csv");
	        System.out.println("Total Execution Time: " + gk.calcExecutionTime(start2, end2) + " ms");
	}
}
