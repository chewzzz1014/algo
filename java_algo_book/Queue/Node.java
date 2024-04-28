package Queue;
public class Node<T> {
    
    private T element;
    private Node<T> next;
    public Node(T t, Node<T> n) {
        element = t;
        next = n;
    }
    public T getElement() {
        return element;
    }
    public Node<T> getNext() {
        return next;
    }
    public void setNext(Node<T> n) {
        next = n;
    }
}
