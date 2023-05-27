import java.util.ArrayList;
import java.util.Collections;

public class DynamicKnapsack extends Knapsack {
	
	public DynamicKnapsack(int n){
		super(n);
	}
	
	public ArrayList<Item> solveKnapsack(ArrayList<Item> items) {
        int[][] dp = new int[items.size() + 1][KNAPSACK_MAX_LIMIT + 1];

        for (int i = 1; i <= items.size(); i++) {
            Item currentItem = items.get(i - 1);
            for (int j = 1; j <= KNAPSACK_MAX_LIMIT; j++) {
                if (currentItem.weight > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], currentItem.worth + dp[i - 1][j - currentItem.weight]);
                }
            }
        }

        // Backtrack to find the selected items
        ArrayList<Item> selectedItems = new ArrayList<>();
        int i = items.size();
        int j = KNAPSACK_MAX_LIMIT;
        while (i > 0 && j > 0) {
            if (dp[i][j] != dp[i - 1][j]) {
                selectedItems.add(items.get(i - 1));
                j -= items.get(i - 1).weight;
            }
            i--;
        }

        // Reverse the order to have the most important items first
        Collections.reverse(selectedItems);
        
        return selectedItems;
    }
}
