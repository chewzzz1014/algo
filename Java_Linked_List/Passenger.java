// Chew Zi Qing
// 212360

// passenger that makes reservation
public class Passenger {
	String name, id;
	int seatNum;
	
	public Passenger(String name, String id, int seatNum) {
		this.name = name;
		this.id = id;
		this.seatNum = seatNum;
	}
	
	// to be used for option 4
	public String toString() {
		return "Passenger Name: "+name+"\nPassenger ID: "+id + "\nSeat Number: " + seatNum;
	}
}
