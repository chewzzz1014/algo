import java_algo_book.CircularlyLinkedList;

public class LinkedCircularQueue<T> implements CircularQueue<T>{
    
    private CircularlyLinkedList<T> list = new CircularlyLinkedList<>();
    
    public LinkedCircularQueue() {

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

    public void rotate() {
        list.rotate();
    }

}
