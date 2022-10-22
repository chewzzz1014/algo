package stack;

public class TestArrayStack {
	public static void main (String[]args) {
		Stack crates = new ArrayStack(4);
		
		crates.push("CARROTS");
		crates.push("ORANGES");
		crates.push("RAISINS");
		crates.push("PICKLES");
		crates.push("BANANAS");
		
		System.out.println("crates.size(): " + crates.size() + "\tcrates.peek(): "+crates.peek());
		
		System.out.println("crates.pop(): " + crates.pop());
		System.out.println("crates.pop(): " + crates.pop());
		System.out.println("crates.pop(): " + crates.pop());
		
		System.out.println("crates.size(): " + crates.size() + "\tcrates.peek(): "+crates.peek());
		
		crates.push("WALNUTS");
		crates.push("OYSTERS");
		
		System.out.println("crates.size(): " + crates.size() + "\tcrates.peek(): "+crates.peek());
		
		System.out.println("crates.pop(): " + crates.pop());
		System.out.println("crates.pop(): " + crates.pop());
		System.out.println("crates.pop(): " + crates.pop());
		System.out.println("crates.pop(): " + crates.pop());
		System.out.println("crates.pop(): " + crates.pop());	// Exception!
	}
}
