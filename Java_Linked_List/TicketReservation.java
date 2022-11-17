import java.util.Scanner;

public class TicketReservation {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		
		Menu m = new Menu();
		m.reserveMenu();
		System.out.println(m.name);
		
	}	
}
