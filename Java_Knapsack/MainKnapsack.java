import java.util.ArrayList;
import java.io.IOException;

public class MainKnapsack {
	public static void main (String [] args) throws IOException{
			final int AIRLINE_LIMIT = 7000;
			final String FILE_PATH_BASE = "C:\\Users\\USER\\eclipse-workspace\\Algo_DS\\Java_Knapsack";
			
			Knapsack ks = new Knapsack(AIRLINE_LIMIT);
		 	ArrayList<Item> items = ks.readItemsFromCSV(FILE_PATH_BASE + "\\items.csv");
		 	
		 	// greedy algorithm
	        GreedyKnapsack gk = new GreedyKnapsack(AIRLINE_LIMIT);
	        ArrayList<Item> result1 = gk.solveKnapsack(items);
	        System.out.println("Greedy Algorithm:");
	        gk.printResult(result1);
	        gk.writeToFile(result1, FILE_PATH_BASE + "\\greedy_results.csv");
	        
	        System.out.println();
	        
	        // dynamic programming
		 	DynamicKnapsack dk = new DynamicKnapsack(AIRLINE_LIMIT);
	        ArrayList<Item> result2 = dk.solveKnapsack(items);
	        System.out.println("Dynamic Programming:");
	        dk.printResult(result2);
	        dk.writeToFile(result2, FILE_PATH_BASE + "\\dynamic_results.csv");
	}
}
