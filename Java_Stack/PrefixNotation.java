import java.util.Scanner;
import java.util.ArrayList;

// application of prefix notation evaluation using ArrayStack
public class PrefixNotation {
	public static void main (String[]args) {
		Scanner sc = new Scanner(System.in);
		
		// reverse the string
		System.out.println("Enter the prefix expression: ");
		StringBuilder expression = new StringBuilder(sc.nextLine()).reverse();
		
		// stack 
		ArrayStack<String> a = new ArrayStack<String>();
		// arraylist for storing all operands that we have to perform operation on (that we've popped)
		ArrayList<Double> b = new ArrayList<Double>();
		
		// checking all items in the expression
		for (int i=0; i<expression.length(); i++) {
			String c = ""+ expression.charAt(i);
			
			// if it's ), digits or operators, push to stack
			if (c.equals(")") || Character.isDigit(expression.charAt(i)) || c.equals("+")  
					|| c.equals("-") || c.equals("*")  || c.equals("/") ) {
				a.push(c);
				System.out.println("Inside stack:");
				System.out.println(a.toString());
			}
			
			// if it's (, pop the topmost operator, all digits above the topmost ) and )
			else if ( c.equals("(") ) {
				String operator = a.pop();
				while(! a.peek().equals(")") ) {
					String operand = a.pop();
					b.add(Double.parseDouble(operand));
					System.out.println("Inside operands ArrayList:");
					System.out.println(b.toString());
				}
				// pop the topmost closing parenthesis
				a.pop();
				
				// perform operations on all the operands popped
				a = performOperation(a, operator, b);
				// clear the operands arraylist
				b.clear();
				System.out.println("Inside stack:");
				System.out.println(a.toString());
			}
		}
		System.out.println("\nAnswer of prefix notation: " + a.peek());
		sc.close();
	}
	
	// perform operations on the operands
	public static ArrayStack<String> performOperation(ArrayStack<String> a, String operator, ArrayList<Double>b) {
		
		// operation type 1: there're >1 operands
		if ( checkOperationType(operator, b.size()) ) {
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
			// push the result into stack
			a.push(String.valueOf(total));
		}else {	
			// operation type 2: there's 0 operand (for * or +) or there's 1 operand (for - and /)
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
			// push the result into stack
			a.push(String.valueOf(result));
		}

		return a;
	}
	
	// check whether we need to perform operation type 1 (for >1 operands) or type 2 (for 0 operand or 1 operand)
	// true for operation type 1 and false for type 2
	public static boolean checkOperationType(String operator, int size) {
		if (operator.equals("+") || operator.equals("*")) 
			return size > 0;
		else
			 return size >1; 
	}
}
