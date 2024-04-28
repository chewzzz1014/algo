package Queue;

public class CircularlyLinkedList<T> {

    private Node<T> tail = null;
    private int size = 0;

    public CircularlyLinkedList() {

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T first() {
        if(isEmpty()) return null;
        return tail.getNext().getElement();
    }

    public T last() {
        if(isEmpty()) return null;
        return tail.getElement();
    }

    public void rotate() {
        if(tail != null)
            tail = tail.getNext();
    }

    public void addFirst(T e) {
        if(isEmpty()) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            Node<T> newNode = new Node<>(e, tail.getNext());
            tail.setNext(newNode);
        }
        size++;
    }

    public void addLast(T e) {
        addFirst(e);
        tail = tail.getNext();
    }

    public T removeFirst() {
        if(isEmpty()) return null;
        Node<T> head = tail.getNext();
        if(head == tail)
            tail = null;
        else
            tail.setNext(head.getNext());
        size--;
        return head.getElement();
    }
}
