package List;
public interface List<T> {

    int size();
    boolean isEmpty();
    T get(int i) throws IndexOutOfBoundsException;
    T set(int i, T ele) throws IndexOutOfBoundsException;
    void add(int i, T ele) throws IndexOutOfBoundsException;
    T remove(int i) throws IndexOutOfBoundsException;
}
