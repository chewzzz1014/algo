package stack;

// implement Stack using Array
// inherit weakly from Stack interface

public class ArrayStack implements Stack {

	private Object[] a;
	private int size;

	// constructor. Define maximum capacity of stack
	public ArrayStack(int capacity){
		a = new Object[capacity];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	// push if does not exist maximum capacity. Else, resize the stack
	public void push(Object o) {
		if (size == a.length)
			resize();
		a[size++] = o;
	}
	
	// pop if stack has at least one element. Else, throw exception
	public Object pop() {
		if (size == 0)
			throw new IllegalStateException("Stack is empty");
		Object o = a[--size];
		a[size] = null;
		return o;
	}
	
	// throw exception if there's no element on stack
	public Object peek() {
		if (size==0)
			throw new IllegalStateException("stack is empty");
		return a[size-1];
	}
	
	public void resize() {
		Object[] aa = a;
		a = new Object[2*aa.length];
		System.arraycopy(aa, 0, a, 0, size);
	}
	
	public int size() {
		return size;
	}
}
