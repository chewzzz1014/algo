// Chew Zi Qing 212360
public class Software {
	public String name, version, key;
	public int quantity, price, position;
	
	public Software(String name, String version, int quantity, int price) {
		this.name = name;
		this.version = version;
		this.quantity = quantity;
		this.price = price;
		this.key = name+" "+version;
	}
	
	
}
