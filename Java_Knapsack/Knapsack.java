import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Knapsack {
	int KNAPSACK_MAX_LIMIT;
	
	public Knapsack(int MAX) {
		KNAPSACK_MAX_LIMIT = MAX;
	}
	
	Item[] readItemsFromCSV(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        ArrayList<Item> itemsList = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            String[] coordinates = line.split(".");
            String name = coordinates[0];
            int worth = Integer.parseInt(coordinates[1]);
            int weight = Integer.parseInt(coordinates[2]);
            itemsList.add(new Item(name, worth, weight));
        }

        reader.close();
        return itemsList.toArray(new Item[0]);
    }
	
	public static void printResult(List<Item> selectedItems) {
        int totalWorth = 0;
        int totalWeight = 0;

        for (Item item : selectedItems) {
            System.out.println(item.toString());
            totalWorth += item.worth;
            totalWeight += item.weight;
        }

        System.out.println("Total Worth: " + totalWorth);
        System.out.println("Total Weight: " + totalWeight);
    }
}
