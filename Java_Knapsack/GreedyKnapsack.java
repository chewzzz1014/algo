import java.util.ArrayList;

public class GreedyKnapsack extends Knapsack {
	public GreedyKnapsack(int n) {
		super(n);
	}
	
	public ArrayList<Item> solveKnapsack(ArrayList<Item> items) {
        ArrayList<Item> selectedItems = new ArrayList<>();

        // Sort items by worth in descending order
        items.sort((a, b) -> Integer.compare(b.worth, a.worth));

        int currentWeight = 0;
        for (Item item : items) {
            if (currentWeight + item.weight <= KNAPSACK_MAX_LIMIT) {
                selectedItems.add(item);
                currentWeight += item.weight;
            }
        }

        return selectedItems;
    }
}

