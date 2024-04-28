package List;
import Stack.Stack;


public class ArrayStack<T> implements Stack<T> {

    public static final int CAPACITY = 1000;
    private T[] data;
    private int t = -1;

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {
        data = (T[]) new Object[capacity];
    }

    public int size() {
        return (t + 1);
    }

    public boolean isEmpty() {
        return t == -1;
    }

    public void push(T ele) throws IllegalStateException {
        if(size() == data.length)
            throw new IllegalStateException("Stack is full");
        data[++t] = ele; 
    }

    public T top() {
        if(isEmpty()) 
            return null;
        return data[t];
    }

    public T pop() {
        if(isEmpty())
            return null;
        T answer = data[t];
        data[t--] = null;
        return answer;
    }
}
