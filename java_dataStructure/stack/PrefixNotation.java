package stack;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class PrefixNotation {
	public static void main (String[]args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder expression = new StringBuilder(sc.nextLine()).reverse();
		
		ArrayStack<String> a = new ArrayStack<String>();
		ArrayList<Double> b = new ArrayList<Double>();
		
		for (int i=0; i<expression.length(); i++) {
			String c = ""+ expression.charAt(i);
			
			if (c.equals(")") || Character.isDigit(expression.charAt(i)) || c.equals("+")  || c.equals("-") || c.equals("*")  || c.equals("/") ) {
				a.push(c);
				System.out.println("a");
				System.out.println(a.toString());
			}
			else if ( c.equals("(") ) {
				String operator = a.pop();
				while(! a.peek().equals(")") ) {
					String operand = a.pop();
					b.add(Double.parseDouble(operand));
					System.out.println("b");
					System.out.println(b.toString());
				}
				// closing parenthesis
				a.pop();
				
				a = performOperation(a, operator, b);
				b.clear();
				System.out.println("a");
				System.out.println(a.toString());
			}
		}
		System.out.println(expression);
		sc.close();
	}
	
	public static ArrayStack<String> performOperation(ArrayStack<String> a, String operator, ArrayList<Double>b) {
		if ( checkCondition(operator, b.size()) ) {
			double total = b.get(0);
			switch(operator) {
			case "+":
				for(int i=1; i<b.size(); i++) 
					total += b.get(i);
				break;
			case "-":
				for(int i=1; i<b.size(); i++) 
					total -= b.get(i);
				break;
			case "*":
				for(int i=1; i<b.size(); i++) 
					total *= b.get(i);
				break;
			case "/":
				for(int i=1; i<b.size(); i++) 
					total /= b.get(i);
				break;
			}
			a.push(String.valueOf(total));
		}else {
			double result = 0;
			switch(operator) {
				case "+":
					result = 0;
					break;
				case "-":
					result = -1 * b.get(0);
					break;
				case "*":
					result = 1;
					break;
				case "/":
					result = 1/b.get(0);
					break;
			}
			a.push(String.valueOf(result));
		}

		return a;
	}
	
	public static boolean checkCondition(String operator, int size) {
		if (operator.equals("+") || operator.equals("*")) 
			return size > 0;
		else
			 return size >1; 
	}
}
