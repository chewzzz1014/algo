import java.util.Scanner;

public class TicketReservation {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		Menu m = new Menu();
		boolean toCont = true;
		
		
		LinkedList<Flight> allFlights = new LinkedList<>();
		
		
//		allFlights.addFirst(new Flight(1));
//		
//		allFlights.getFirst().passengers.addFirst(new Passenger("chewzzz", "212360", 0));
//		allFlights.getFirst().passengers.addFirst(new Passenger("chew", "211111", 1));
//		
//		System.out.println(allFlights.getFirst().toString());
		
		while(toCont) {
			
			toCont = continueTransaction(sc);
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
