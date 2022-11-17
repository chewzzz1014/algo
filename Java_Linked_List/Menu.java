// Chew Zi Qing
// 212360

//Write a simple airline ticket reservation program using linked list. The program should display a menu with the following options:
//-	Reserve a ticket
//-	Cancel a reservation
//-	Check whether a ticket is reserves for a particular person
//-	Display the passengers
import java.util.Scanner;

public class Menu {
	public int option, flightNum, seatNum;
	public String name, id;
	public double price;
	Scanner sc = new Scanner (System.in);
	
	public void mainMenu() {
		System.out.println("1. Reserve a Ticket");
		System.out.println("2. Cancel a Reservation");
		System.out.println("3. Check Seat Availability");
		System.out.println("4. Check Seat Passengers");
		
		option = sc.nextInt();
	}
	
	public void reserveMenu() {
		// get passenger name, id
		// display price and success message(seat number)
		System.out.println("-------------------Reserving ticket------------------");
		System.out.println("Enter Passenger Name: ");
		name = sc.nextLine();
		
		System.out.println("Enter Passenger ID: ");
		id = sc.nextLine();
		
		System.out.println("Enter Flight Number: ");
		flightNum = sc.nextInt();
		
		System.out.println("Enter Seat Number (0-39): ");
		seatNum = sc.nextInt();
		
		System.out.println("Reservation completed!");
	}
	
	public void cancelMenu() {
		System.out.println("-------------------Canceling reservation------------------");
		System.out.println("Enter Flight Number: ");
		flightNum = sc.nextInt();
		
		System.out.println("Enter Seat Number (0-39): ");
		seatNum = sc.nextInt();
		System.out.println("Reservation cancelled!");
	}
	
	public void checkAvailibilityMenu() {
		System.out.println("-------------------Checking Ticket Availibility------------------");
		System.out.println("Enter Seat Number (0-39): ");
		seatNum = sc.nextInt();
		
		System.out.println("finding...");
	}
	
	public void checkPassengerMenu() {
		System.out.println("-------------------Passenger info------------------");
		System.out.println();
	}
}
