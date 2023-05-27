
public class Item {
	String name;
	int worth, weight;
	
	public Item(String n, int worth, int weight) {
		name = n;
		this.worth = worth;
		this.weight = weight;
	}
	
	public String toString() {
		return name + ";Worth: " + worth + ";Weight: " + weight + "g.";
	}
}
