import java.util.Scanner;

public class TicketReservation {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		
		LinkedList<Integer> l = new LinkedList<>();
		
		l.addFirst(12);
		l.addFirst(13);
		l.addFirst(14);
		l.addFirst(15);
		l.addFirst(16);
		
		System.out.println(l.toString());
		
		l.removeLast();
		System.out.println(l.toString());
	}
}
