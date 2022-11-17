// Chew Zi Qing
// 212360

//Write a simple airline ticket reservation program using linked list. The program should display a menu with the following options:
//-	Reserve a ticket
//-	Cancel a reservation
//-	Check whether a ticket is reserves for a particular person
//-	Display the passengers
import java.util.Scanner;

public class Menu {
	public int flightNum, seatNum;
	public String name, id, option;
	public double price;
	Scanner sc = new Scanner (System.in);
	
	public void mainMenu() {
		System.out.println("1. Reserve a Ticket");
		System.out.println("2. Cancel a Reservation");
		System.out.println("3. Check Seat Availability");
		System.out.println("4. Check Seat Passengers");
		
		System.out.println("What would you like to do?");
		option = sc.nextLine();
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
		flightNum = Integer.valueOf(sc.nextLine());
		
		System.out.println("Enter Seat Number (0-39): ");
		seatNum = Integer.valueOf(sc.nextLine());
		
		System.out.println("Reservation completed!");
		System.out.println("-----------------------------------------------------");
	}
	
	public void cancelMenu() {
		System.out.println("-------------------Canceling reservation------------------");
		System.out.println("Enter Flight Number: ");
		flightNum = Integer.valueOf(sc.nextLine());
		
		System.out.println("Enter Seat Number (0-39): ");
		seatNum = Integer.valueOf(sc.nextLine());
		System.out.println("-----------------------------------------------------");
	}
	
	public void checkAvailibilityMenu() {
		System.out.println("-------------------Checking Ticket Availibility------------------");
		System.out.println("Enter Flight Number: ");
		flightNum = Integer.valueOf(sc.nextLine());
		
		System.out.println("Enter Seat Number (0-39): ");
		seatNum = Integer.valueOf(sc.nextLine());
		
		System.out.println("finding...");
	}
	
	public void checkPassengerMenu() {
		System.out.println("-------------------Passenger info------------------");
	}
}
