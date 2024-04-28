package List;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T> {
    

    // nested class
    private class ArrayIterator implements Iterator<T> {
        private int i = 0; // index of next element to report
        private boolean removable = false;

        public boolean hasNext() {
            return i < size; // size is field from outer instance
        }

        public T next() throws NoSuchElementException {
            if(i == size)
                throw new NoSuchElementException("No next element");
            removable = true; // this element can subsequently be removed
            return data[i++];
        }

        public void remove() throws IllegalStateException {
            if(!removable)
                throw new IllegalStateException("nothing to remove");
            ArrayList.this.remove(i-1);
            i--;
            removable = false;
        }
    }
    // end of nested class


    public static final int CAPACITY = 16;
    private T[] data;
    private int size = 0;

    public ArrayList() {
        this(CAPACITY);
    }

    public ArrayList(int capacity) {
        data = (T[]) new Object[capacity];
    }

    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    public T set(int i, T ele) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        T temp = data[i];
        data[i] = ele;
        return temp;
    }

    public void add(int i, T ele) throws IndexOutOfBoundsException{
        checkIndex(i, size + 1);
        if(size == data.length)
            resize(2 * data.length);
        for(int k=size-1; k>=i; k--)
            data[k+1] = data[k]; // shift to right
        data[i] = ele;
        size++;
    }

    public T remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        T temp = data[i];
        for(int k=i; k<size-1; k++)
            data[k] = data[k+1];
        data[size-1] = null;
        size--;
        return temp;
    }

    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if(i <= 0 || i >= n)
            throw new IndexOutOfBoundsException("Illegal index: " + i);
    }

    protected void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        for(int i=0; i<size; i++)
            temp[i] = data[i];
        data = temp;
    }
}
