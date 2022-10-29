import java.util.ArrayList;
import java.util.Arrays;

// implement Stack using generic ArrayList
public class ArrayStack<T> {

	private ArrayList<T> a;
	private int size;

	// constructor to make a generic ArrayList
	public ArrayStack(){
		a = new ArrayList<T>();
	}
	
	// check if the stack is empty
	public boolean isEmpty() {
		return size == 0;
	}
	
	// push element into the stack
	public void push(T o) {
		a.add(size++, o);
	}
	
	// pop if stack has at least one element. Else, throw exception
	public T pop() {
		if (size == 0)
			throw new IllegalStateException("Stack is empty");
		T o = a.get(--size); 
		a.remove(size);
		return o;
	}
	
	// return the top element on stack
	// throw exception if there's no element on stack
	public T peek() {
		if (size==0)
			throw new IllegalStateException("stack is empty");
		return a.get(size-1); 
	}
	
	// get the size of stack
	public int size() {
		return size;
	}
	
	// print all the elements in the stack
	public String toString() {
		return Arrays.toString(a.toArray());
	}
	
}
