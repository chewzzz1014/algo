// Chew Zi Qing 212360
public class Software {
	public String name, version, key;
	public int quantity, price, position;
	
	public Software(String name, int quantity, int price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.key = name;
	}
	
	public Software(String name, String version, int quantity, int price) {
		this(name, quantity, price);
		this.version = version;
		this.key = name+" "+version;
	}
	
	public String toString() {
		return "Software: "+key+"\nQuantity: "+quantity+"\nPrice: RM "+price;
	}
	
}
