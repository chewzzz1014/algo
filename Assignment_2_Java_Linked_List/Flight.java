// Chew Zi Qing
// 212360

// flights that has flight number and a linked list of passengers
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
		info += "\n****************";
		
		return info;
	}
	
}
