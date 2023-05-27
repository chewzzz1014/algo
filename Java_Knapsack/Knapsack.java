import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class Knapsack{
	int KNAPSACK_MAX_LIMIT;
	
	public Knapsack(int MAX) {
		KNAPSACK_MAX_LIMIT = MAX;
	}
	
	ArrayList<Item> readItemsFromCSV(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        ArrayList<Item> itemsList = new ArrayList<>();
        String line;

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
	
	public void writeToFile(ArrayList<Item> result, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
        	writer.write("Item,Worth,Weight\n");
        	for(Item item : result) {
        		 writer.write(item.toString());
        	}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
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
}
