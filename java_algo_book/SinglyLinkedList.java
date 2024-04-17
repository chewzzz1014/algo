package java_algo_book;

public class SinglyLinkedList<T> implements Cloneable{
    
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public SinglyLinkedList() {

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T first() {
        if(isEmpty()) return null;
        return head.getElement();
    }

    public T last() {
        if(isEmpty()) return null;
        return tail.getElement();
    }

    public void addFirst(T e) {
        head = new Node<>(e, head);
        if(size == 0) tail = head;
        size++;
    }

    public void addLast(T e) {
        Node<T> newNode = new Node<>(e, null);
        if(isEmpty()) head = newNode;
        else tail.setNext(newNode);
        size++;
    }

    public T removeFirst() {
        if(isEmpty()) return null;
        T element = head.getElement();
        head = head.getNext();
        size--;
        if(size==0) tail = null;
        return element;
    }

    public boolean equals(Object o) {
        if(o == null) return false;
        if(getClass() != o.getClass()) return false;

        SinglyLinkedList other = (SinglyLinkedList) o;
        if(size != other.size) return false;
        
        Node walkA = head;
        Node walkB = other.head;
        while(walkA != null) {
            if(!walkA.getElement().equals(walkB.getElement())) return false;
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }

        return true;
    }

    @Override
    public SinglyLinkedList<T> clone() throws CloneNotSupportedException {
        SinglyLinkedList<T> other = (SinglyLinkedList<T>) super.clone(); // use Object's clone()

        if(size > 0) {
            other.head = new Node<>(head.getElement(), null);
            Node<T> walk = head.getNext(); // one step ahead of otherTail
            Node<T> otherTail = other.head;

            while(walk != null) {
                Node<T> newNode = new Node<>(walk.getElement(), null);
                otherTail.setNext(newNode);
                otherTail = newNode;
                walk = walk.getNext();
            }
        }
    }
}
