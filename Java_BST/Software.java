// Chew Zi Qing 212360
// contains information about Software
public class Software {
	// 'key' is used for BST node labeling
	public String name, version, key;
	public int quantity, position;
	public double price;
	
	// constructor for software w/o version
	public Software(String name, int quantity, double price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.key = name;
	}
	
	// constructor for software w/ version
	public Software(String name, String version, int quantity, double price) {
		this(name, quantity, price);
		this.version = version;
		this.key = name+" "+version;
	}
	
	// return Software info as String
	public String toString() {
		return "Software: "+key+"\nQuantity: "+quantity+"\nPrice: RM "+
				String.format("%.2f", price);
	}
	
}
