
public class Passenger {
	String name, id;
	
	public Passenger(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public String toString() {
		return "Passenger Name: "+name+"\nPassenger ID: "+id;
	}
}
