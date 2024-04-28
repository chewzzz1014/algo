package List;

public class DoublyLinkedList<T> {

    private static class DoublyNode<T> {
        private T element;
        private DoublyNode<T> prev;
        private DoublyNode<T> next;

        public DoublyNode(T e, DoublyNode<T> p, DoublyNode<T> n) {
            element = e;
            prev = p;
            next = n;
        }

        public T getElement() {
            return element;
        }

        public DoublyNode<T> getPrev() {
            return prev;
        }

        public DoublyNode<T> getNext() {
            return next;
        }

        public void setPrev(DoublyNode<T> p) {
            prev = p;
        }

        public void setNext(DoublyNode<T> n) {
            next = n;
        }
    }

    private DoublyNode<T> header;
    private DoublyNode<T> trailer;
    private int size = 0;

    public DoublyLinkedList() {
        header = new DoublyNode<>(null, null, null);
        trailer = new DoublyNode<>(null, null, null);
        header.setNext(trailer);
    }

    public int size( ) { 
        return size; 
    }
   
    public boolean isEmpty( ) { 
        return size == 0; 
    }

    public T first() {
        if(isEmpty()) return null;
        return header.getNext().getElement();
    }

    public T last() {
        if(isEmpty()) return null;
        return trailer.getPrev().getElement();
    }

    public void addFirst(T e) {
        addBetween(e, header, header.getNext());
    }

    public void addLast(T e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    public T removeFirst() {
        if(isEmpty()) return null;
        return remove(header.getNext());
    }

    public T removeLast() {
        if(isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    private void addBetween(T e, DoublyNode<T> predecessor, DoublyNode<T> successor) {
        DoublyNode<T> newNode = new DoublyNode<>(e, predecessor, successor);
        predecessor.setNext(newNode);
        successor.setPrev(newNode);
        size++;
    }

    private T remove(DoublyNode<T> node) {
        DoublyNode<T> predecessor = node.getPrev();
        DoublyNode<T> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
}
