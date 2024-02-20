// Chew Zi Qing 212360
public class Item {
	String name;
	int worth, weight;
	
	public Item(String name, int worth, int weight) {
		this.name = name;
		this.worth = worth;
		this.weight = weight;
	}
	
	public String toString() {
		return name + "," + worth + "," + weight + "\n";
	}
}
