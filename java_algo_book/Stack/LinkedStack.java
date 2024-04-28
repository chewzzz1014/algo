package Stack;
import List.SinglyLinkedList;

public class LinkedStack<T> implements Stack<T> {
    
    private SinglyLinkedList<T> list = new SinglyLinkedList<>();

    public LinkedStack() {}

    public int size() {return list.size();}

    public boolean isEmpty() {return list.isEmpty();}

    public void push(T ele) {list.addFirst(ele);}

    public T top() {return list.first();}

    public T pop() {return list.removeFirst();}
}
