// Chew Zi Qing 212360
public class Software {
	private String name, version;
	private int quantity, price, position;
	
	public Software(String name, String version, int quantity, int price) {
		this.name = name;
		this.version = version;
		this.quantity = quantity;
		this.price = price;
	}
	
	public String getKey() {
		return name+" "+version;
	}
}
