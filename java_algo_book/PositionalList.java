import java.util.Iterator;

public interface PositionalList<T> {
    
    int size();
    boolean isEmpty();

    Position<T> first();
    Position<T> last();
    Position<T> before(Position<T> p) throws IllegalArgumentException;
    Position<T> after(Position<T> p) throws IllegalArgumentException;

    Position<T> addFirst(T ele);
    Position<T> addLast(T ele);
    Position<T> addBefore(Position<T> p, T ele) throws IllegalArgumentException;
    Position<T> addAfter(Position<T> p, T ele) throws IllegalArgumentException;

    T set(Position<T> p, T ele) throws IllegalArgumentException;
    T remove(Position<T> p) throws IllegalArgumentException;

    Iterator<T> iterator();
}
