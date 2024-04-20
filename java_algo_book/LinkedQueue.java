import java_algo_book.SinglyLinkedList;

public class LinkedQueue<T> implements Queue<T> {
    
    private SinglyLinkedList<T> list = new SinglyLinkedList<>();
    
    public LinkedQueue() {

    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enqueue(T ele) {
        list.addLast(ele);
    }

    public T first() {
        return list.first();
    }

    public T dequeue() {
        return list.removeFirst();
    }
}
