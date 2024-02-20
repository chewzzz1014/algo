// Chew Zi Qing 212360
import java.util.ArrayList;

//Greedy approach of Knapsack problem
public class GreedyKnapsack extends Knapsack {
	public GreedyKnapsack(int n) {
		super(n);
	}
	
	public ArrayList<Item> solveKnapsack(ArrayList<Item> items) {
        ArrayList<Item> selectedItems = new ArrayList<>();

        // sort items by worth in descending order
        // to prioritize item w/ higher worth
        items.sort((a, b) -> Integer.compare(b.worth, a.worth));

        int currentWeight = 0;
        for (Item item : items) {
        	// if we include this item, will the total weight exceed max weight?
            if (currentWeight + item.weight <= KNAPSACK_MAX_LIMIT) {
            	// if no, include it!
                selectedItems.add(item);
                currentWeight += item.weight;
            }
        }

        return selectedItems;
    }
}

