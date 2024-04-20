public class ArrayList<T> implements List<T> {
    
    public static final int CAPACITY = 16;
    private T[] data;
    private int size = 0;

    public ArrayList() {
        this(CAPACITY);
    }

    public ArrayList(int capacity) {
        data = (T[]) new Object[capacity];
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
