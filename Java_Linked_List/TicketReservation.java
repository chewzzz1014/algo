import java.util.Scanner;

public class TicketReservation {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		Menu m = new Menu();
		boolean toCont = true;
		
		
		LinkedList<Flight> allFlights = new LinkedList<>();
		
		while(toCont) {
			m.mainMenu();
			
			switch(m.option) {
				case "1":
					m.reserveMenu();
					
					allFlights.addLast(new Flight(m.flightNum));
					allFlights.getData(m.flightNum).passengers.add(m.seatNum, new Passenger(m.name, m.id, m.seatNum));
					//System.out.println(allFlights.getFirst().toString());
					break;
				case "2":
					m.cancelMenu();
					
					// flightNum, seatNum
					
					break;
				case "3":
					m.checkAvailibilityMenu();
					break;
				case "4":
					m.checkPassengerMenu();
					
					System.out.println(allFlights.toString());
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
