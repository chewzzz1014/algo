// Chew Zi Qing 212360
import java.util.ArrayList;
import java.util.Collections;

// Dynamic approach of Knapsack problem
public class DynamicKnapsack extends Knapsack {
	
	public DynamicKnapsack(int n){
		super(n);
	}
	
	// implement the Dynamic Programming Knapsack
	public ArrayList<Item> solveKnapsack(ArrayList<Item> items) {
		// create a 'table' to find max worth for specific combination of items and weight 
        int[][] dp = new int[items.size() + 1][KNAPSACK_MAX_LIMIT + 1];

        // row 0 and col 0 are omitted
        // iterate every row (each item)
        for (int i = 1; i <= items.size(); i++) {
            Item currentItem = items.get(i - 1);
            
            // iterate every col (each possible weight)
            for (int j = 1; j <= KNAPSACK_MAX_LIMIT; j++) {
            	
            	// current item weight > current max weight
                if (currentItem.weight > j) {
                    dp[i][j] = dp[i - 1][j]; // item can't be included
                } else {
                	// find max possible worth
                    dp[i][j] = Math.max(dp[i - 1][j], currentItem.worth + dp[i - 1][j - currentItem.weight]);
                }
            }
        }

        // backtrack to find the selected items
        ArrayList<Item> selectedItems = new ArrayList<>();
        
        // start from bottom right of table
        int i = items.size();
        int j = KNAPSACK_MAX_LIMIT;
        
        // check from bottom to top & right to left
        while (i > 0 && j > 0) {
        	// if this value is diff from value from prev row & same col
            if (dp[i][j] != dp[i - 1][j]) {
            	// include this item as optimal solution
                selectedItems.add(items.get(i - 1));
                j -= items.get(i - 1).weight;
     
            }
            i--;
        }
        
        // reverse the items list, start with most important items first
        Collections.reverse(selectedItems);
        
        return selectedItems;
    }
}
