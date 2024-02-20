// Chew Zi Qing
// 212360
import java.util.Scanner;

// for displaying menu and asking for input
public class Menu {
	public int flightNum, seatNum;
	public String name, id, option;
	public double price;
	Scanner sc = new Scanner (System.in);
	
	// display main menu and ask for next step
	public void mainMenu() {
		System.out.println("1. Reserve a Ticket");
		System.out.println("2. Cancel a Reservation");
		System.out.println("3. Check Seat Availability");
		System.out.println("4. Check Seat Passengers");
		
		System.out.println("What would you like to do?");
		option = sc.nextLine();
	}
	
	// display reservation menu and ask for passenger name, id and flight number and seat number
	public void reserveMenu() {
		System.out.println("-------------------Reserving ticket------------------");
		System.out.println("Enter Passenger Name: ");
		name = sc.nextLine();
		
		System.out.println("Enter Passenger ID: ");
		id = sc.nextLine();
		
		System.out.println("Enter Flight Number: ");
		flightNum = Integer.valueOf(sc.nextLine());
		
		System.out.println("Enter Seat Number (0-39): ");
		seatNum = Integer.valueOf(sc.nextLine());
		
		System.out.println("Reservation completed!");
		System.out.println("-----------------------------------------------------");
	}
	
	// display cancellation menu and ask for flight number and seat number
	public void cancelMenu() {
		System.out.println("-------------------Canceling reservation------------------");
		System.out.println("Enter Flight Number: ");
		flightNum = Integer.valueOf(sc.nextLine());
		
		System.out.println("Enter Seat Number (0-39): ");
		seatNum = Integer.valueOf(sc.nextLine());
	
	}
	
	// display menu for checking whether a ticket is reserves for a particular person 
	// ask for flight number and seat number
	public void checkAvailibilityMenu() {
		System.out.println("-------------------Checking Ticket Availibility------------------");
		System.out.println("Enter Flight Number: ");
		flightNum = Integer.valueOf(sc.nextLine());
		
		System.out.println("Enter Seat Number (0-39): ");
		seatNum = Integer.valueOf(sc.nextLine());
		
		System.out.println("\nfinding...");
	}
	
	// display all passengers for all flights
	public void checkPassengerMenu() {
		System.out.println("-------------------Passenger info------------------");
	}
}
