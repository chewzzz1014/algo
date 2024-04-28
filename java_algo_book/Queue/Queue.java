package Queue;
public interface Queue<T> {
    
    int size();
    boolean isEmpty();
    void enqueue(T ele);
    T first();
    T dequeue();
}
