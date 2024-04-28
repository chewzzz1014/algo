package Queue;
public interface Deque<T> {
    
    int size();
    boolean isEmpty();
    T first();
    T last();
    void addFirst(T ele);
    void addLast(T ele);
    void removeFirst();
    void removeLast();
}
