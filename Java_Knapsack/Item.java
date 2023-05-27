
public class Item {
	String name;
	int value, weight;
	
	public Item(String n, int v, int w) {
		name = n;
		value = v;
		weight = w;
	}
	
	public String toString() {
		return name + " - Worth: " + value + ", Weight: " + weight;
	}
}
