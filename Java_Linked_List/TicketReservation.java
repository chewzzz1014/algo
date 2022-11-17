// Chew Zi Qing
// 212360
import java.util.Scanner;
import java.util.ArrayList;

public class TicketReservation {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> flightsRecorded = new ArrayList<>();
		Menu m = new Menu();
		boolean toCont = true;
		
		
		LinkedList<Flight> allFlights = new LinkedList<>();
		
		while(toCont) {
			m.flightNum = -1;
			m.seatNum = -1;
			
			m.mainMenu();
			
			switch(m.option) {
				case "1":
					m.reserveMenu();
					
					if (flightsRecorded.indexOf(m.flightNum) == -1) {
						flightsRecorded.add(m.flightNum);
						allFlights.addLast(new Flight(m.flightNum));
					}
					allFlights.getData(allFlights.indexOf("flight", m.flightNum)).passengers.addLast(new Passenger(m.name, m.id, m.seatNum));
					//System.out.println(allFlights.toString());
					break;
					
				case "2":
					m.cancelMenu();
					
					int flightIdx = allFlights.indexOf("flight", m.flightNum);
					if (flightIdx != -1) {
						Flight f = allFlights.getData(flightIdx);
						int pIdx = f.passengers.indexOf("passenger", m.seatNum);
						Passenger p = f.passengers.remove(pIdx);
						if (pIdx != -1) {
							//System.out.println(p + " found!");
							System.out.println("Reservation cancelled!");
						}else {
							System.out.println("Unreserved Seat!");
						}		
						
					}else {
						System.out.println("Invalid Flight Number!");
					}
					System.out.println("-----------------------------------------------------");
					break;
					
				case "3":
					m.checkAvailibilityMenu();
					
					flightIdx = allFlights.indexOf("flight", m.flightNum);
					if (flightIdx != -1) {
						Flight f = allFlights.getData(flightIdx);
						int pIdx = f.passengers.indexOf("passenger", m.seatNum);
						Passenger p = f.passengers.getData(pIdx);
						if (pIdx == -1) {
							//System.out.println(p + " found!");
							System.out.println("Reservation available!");
						}else {
							System.out.println("Passenger who had reserved flight " + m.flightNum + " seat "+m.seatNum + ": ");
							System.out.println (p);
						}		
						
					}else {
						System.out.println("Invalid Flight Number!");
					}
					System.out.println("-----------------------------------------------------");
					break;
					
				case "4":
					m.checkPassengerMenu();
					
					System.out.println(allFlights.toString());
					System.out.println("-----------------------------------------------------");
					break;	
			}
			toCont = continueTransaction(sc);
			System.out.println();
		}
		
	}	
	
	public static boolean continueTransaction(Scanner sc) {
		String getToCont;
		System.out.println("Do you wish to continue? (y/n)");
		getToCont = sc.nextLine();
		if (getToCont.toLowerCase().charAt(0) == 'n')
			return false;
		else
			return true;
	}
}
