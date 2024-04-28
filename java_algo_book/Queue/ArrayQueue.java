package Queue;
public class ArrayQueue<T> implements Queue<T> {
    
    private T[] data;
    private int f = 0;
    private int sz = 0;
    private static final int CAPACITY = 50;

    public ArrayQueue() {
        this(CAPACITY);
    }
    
    public ArrayQueue(int capacity) {
        data = (T[]) new Object[capacity];
    }

    public int size() {
        return sz;
    }

    public boolean isEmpty() {
        return sz == 0;
    }

    public void enqueue(T ele) throws IllegalStateException {
        if(sz == data.length)
            throw new IllegalStateException("Queue is full");
        int avail = (f + sz) % data.length;
        data[avail] = ele;
        sz++;
    }

    public T first() {
        if(isEmpty()) return null;
        return data[f];
    }

    public T dequeue() {
        if(isEmpty()) return null;
        T frontEle = data[f];
        f = (f + 1) % data.length;
        sz--;
        return frontEle;
    }
}
