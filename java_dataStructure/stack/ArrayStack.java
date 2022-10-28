package stack;

import java.util.ArrayList;
import java.util.Arrays;

// implement Stack using Array
// inherit weakly from Stack interface

public class ArrayStack implements Stack {

	private ArrayList<Object> a;
	private int size;

	// constructor. Define maximum capacity of stack
	public ArrayStack(){
		a = new ArrayList<Object>();
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	// push if does not exist maximum capacity. Else, resize the stack
	public void push(Object o) {
		a.add(size++, o);
	}
	
	// pop if stack has at least one element. Else, throw exception
	public Object pop() {
		if (size == 0)
			throw new IllegalStateException("Stack is empty");
		Object o = a.get(--size); 
		a.set(size, null);
		return o;
	}
	
	// throw exception if there's no element on stack
	public Object peek() {
		if (size==0)
			throw new IllegalStateException("stack is empty");
		return a.get(size-1); 
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		return Arrays.toString(a.toArray());
	}
}
