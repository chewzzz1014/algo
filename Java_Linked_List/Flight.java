
public class Flight {
	public int flightNum;
	public LinkedList<Passenger> passengers;
	
	public Flight(int n) {
		flightNum = n;
		passengers = new LinkedList<>();
	}
	
	public String toString() {
		String info = "";
		info += "Flight Number: " + flightNum + "\n\n";
		info += passengers.toString();
		info += "****************";
		
		return info;
	}
	
}
