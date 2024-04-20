public class LinkedPositionalList<T> implements PositionalList<T> {
    
    // nested class
    private static class Node<T> implements Position<T> {
        private T element;
        private Node<T> prev;
        private Node<T> next;
        public Node(T ele, Node<T> p, Node<T> n) {
            element = ele;
            prev = p;
            next = n;
        }
        public T getElement() throws IllegalStateException {
            if(next == null) throw new IllegalStateException("Position no longer valid");
            return element;
        }
        public Node<T> getPrev( ) {
            return prev;
        }
        public Node<T> getNext( ) {
            return next;
        }
        public void setElement(T e) {
            element = e;
        }
        public void setPrev(Node<T> p) {
            prev = p;
        }
        public void setNext(Node<T> n) {
            next = n;
        }
    }

    private Node<T> header;
    private Node<T> trailer;
    private int size = 0;

    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    private Node<T> validate(Position<T> p) throws IllegalArgumentException {
        if(!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
        Node<T> node = (Node<T>) p;
        if(node.getNext() == null)
            throw new IllegalArgumentException("p is no longer in the list");
        return node;
    }

    private Position<T> position(Node<T> node) {
        if(node == header || node == trailer)
            return null;
        return node;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Position<T> first() {
        return position(header.getNext());
    }

    public Position<T> last() {
        return position(trailer.getPrev());
    }

    public Position<T> before(Position<T> p) throws IllegalArgumentException {
        Node<T> node = validate(p);
        return position(node.getPrev());
    }

    public Position<T> after(Position<T> p) throws IllegalArgumentException {
        Node<T> node = validate(p);
        return position(node.getNext());
    }

    private Position<T> addBetween(T ele, Node<T> pred, Node<T> succ) {
        Node<T> newNode = new Node<>(e, pred, succ);
        pred.setNext(newNode);
        succ.setPrev(newNode);
        size++;
        return newNode;
    }

    public Position<T> addFirst(T ele) {
        return addBetween(ele, header, header.getNext());
    }

    public Position<T> addLast(T ele) {
        return addBetween(ele, trailer.getPrev(), trailer);
    }

    public Position<T> addBefore(Position<T> p, T ele) throws IllegalArgumentException {
        Node<T> node = validate(p);
        return addBetween(ele, node.getPrev(), node);
    }

    public Position<T> addAfter(Position<T> p, T ele) throws IllegalArgumentException {
        Node<T> node = validate(p);
        return addBetween(ele, node, node.getNext());
    }

    public T set(Position<T> p, T ele) throws IllegalArgumentException {
        Node<T> node = validate(p);
        T answer = node.getElement();
        node.setElement(ele);
        return answer;
    }

    public T remove(Position<T> p) throws IllegalArgumentException {
        Node<T> node = validate(p);
        Node<T> pred = node.getPrev();
        Node<T> succ = node.getNext();

        pred.setNext(succ);
        succ.setPrev(pred);
        size--;

        // for garbage collection
        T answer = node.getElement();
        node.setElement(null);
        node.setPrev(null);
        node.setNext(null);
        
        return answer;
    }
}
