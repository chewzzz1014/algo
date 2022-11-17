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
		
		// a linked list of flights
		LinkedList<Flight> allFlights = new LinkedList<>();
		
		// repeatedly ask for user option
		while(toCont) {
			// display main menu
			m.mainMenu();
			
			switch(m.option) {
			
				// option 1: reserve ticker
				case "1":
					// get passenger name and id, and flight number and seat number
					m.reserveMenu();
					
					// if linkedlist doesn't have flight of given flight number
					// then create one and add to linkedlist
					if (flightsRecorded.indexOf(m.flightNum) == -1) {
						flightsRecorded.add(m.flightNum);
						allFlights.addLast(new Flight(m.flightNum));
					}
					// add reservation to the given flight number and seat number
					allFlights.getData(allFlights.indexOf("flight", m.flightNum))
							.passengers.addLast(new Passenger(m.name, m.id, m.seatNum));
					
					break;
					
				// option 2: cancel reservation
				case "2":
					// get flight number and seat number
					m.cancelMenu();
					
					int flightIdx = allFlights.indexOf("flight", m.flightNum);
					
					// check if the flight exists
					if (flightIdx != -1) {
						Flight f = allFlights.getData(flightIdx);
						int pIdx = f.passengers.indexOf("passenger", m.seatNum);
						Passenger p = f.passengers.remove(pIdx);
						
						// check is the seat been reserved
						if (pIdx != -1) {
							System.out.println("Reservation cancelled!");
						}else {
							System.out.println("Unreserved Seat!");
						}		
						
					}else {
						System.out.println("Invalid Flight Number!");
					}
					System.out.println("-----------------------------------------------------");
					break;
					
				// option 3: check whether a seat is been reserved. Return the passenger if it does
				case "3":
					// get flight number and seat number
					m.checkAvailibilityMenu();
					
					flightIdx = allFlights.indexOf("flight", m.flightNum);
					
					// check if the flight existed
					if (flightIdx != -1) {
						Flight f = allFlights.getData(flightIdx);
						int pIdx = f.passengers.indexOf("passenger", m.seatNum);
						Passenger p = f.passengers.getData(pIdx);
						
						// check if the seat has been reserved
						if (pIdx == -1) {
							System.out.println("Reservation available!");
						}else {
							System.out.println("Passenger who had reserved flight "
									+ m.flightNum + " seat "+m.seatNum + ": ");
							System.out.println (p);
						}		
						
					}else {
						System.out.println("Invalid Flight Number!");
					}
					System.out.println("-----------------------------------------------------");
					break;
					
				// option 4: display all passengers for all flights
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
	
	// check whether to continue the while loop
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
