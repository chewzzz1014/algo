package stack;
import java.util.Arrays;
import java.util.Scanner;

public class PrefixNotation {
	public static void main (String[]args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder expression = new StringBuilder(sc.nextLine()).reverse();
		
		ArrayStack a = new ArrayStack();
		
		for (int i=0; i<expression.length(); i++) {
			Character c = expression.charAt(i);
			
			if (c == ')' || Character.isDigit(c)) {
				a.push(c);
				System.out.println(a.toString());
			}
			else if ( c== '(') {
				a.pop();
				System.out.println(a.toString());
			}
		}
		System.out.println(expression);
		sc.close();
	}	
}
