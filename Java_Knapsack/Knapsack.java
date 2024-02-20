// Chew Zi Qing 212360
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;

// generic class for Knapsack approaches
public class Knapsack{
	// define max weight
	int KNAPSACK_MAX_LIMIT;
	
	public Knapsack(int MAX) {
		KNAPSACK_MAX_LIMIT = MAX;
	}
	
	// read list of items from items.csv
	ArrayList<Item> readItemsFromCSV(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        ArrayList<Item> itemsList = new ArrayList<>();
        String line;
        // parse values of each line and create new Item instance
        while ((line = reader.readLine()) != null) {
            String[] coordinates = line.split(",");
            String name = coordinates[0];
            int worth = Integer.parseInt(coordinates[1]);
            int weight = Integer.parseInt(coordinates[2]);
            itemsList.add(new Item(name, worth, weight));
        }

        reader.close();
        return itemsList;
    }
	
	// write list of items into new csv 
	// items are ranked from most important to less important (based on worth)
	public void writeToFile(ArrayList<Item> result, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
        	writer.write("Item,Worth,Weight\n");
        	for (Item item: result) {
                writer.write(item.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	// print total worth and weight of the approach
	public void printResult(ArrayList<Item> selectedItems) {
        int totalWorth = 0;
        int totalWeight = 0;

        for (Item item : selectedItems) {
            totalWorth += item.worth;
            totalWeight += item.weight;
        }

        System.out.println("Total Worth: " + totalWorth);
        System.out.println("Total Weight: " + totalWeight);
    }
	
	// calc execution time in ms
	public long calcExecutionTime(long start, long end) {
		return (end - start) / 1_000_000;
	}
	
}
