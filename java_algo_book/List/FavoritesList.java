package List;
import java.util.Iterator;

public class FavoritesList<T> {
    
    // nested class: item
    protected static class Item<T> {
        private T value;
        private int count = 0;
        public Item(T val) {value = val;}
        public T getValue() {return value;}
        public int getCount() {return count;}
        public void increment() {count++;}
    }
    // end of nested class: item

    PositionalList<Item<T>> list = new LinkedPositionalList<>();

    public FavoritesList() {

    }
    protected T value(Position<Item<T>> p) {
        return p.getElement().getValue();
    }
    protected int count(Position<Item<T>> p) {
        return p.getElement().getCount();
    }
    protected Position<Item<T>> findPosition(T ele) {
        Position<Item<T>> walk = list.first();
        while(walk != null && !ele.equals(value(walk)))
            walk = list.after(walk);
        return walk;
    }
    protected void moveUp(Position<Item<T>> p) {
        int cnt = count(p);
        Position<Item<T>> walk = p;
        while(walk != list.first() && count(list.before(walk)) < cnt)
            walk = list.before(walk);
        if(walk != p)
            list.addBefore(walk, list.remove(p));
    }
    public int size() {
        return list.size();
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    // access an element (possibly new), increase its access count
    public void access(T ele) {
        Position<Item<T>> p = findPosition(ele);
        if(p == null)
            p = list.addLast(new Item<T>(ele));
        p.getElement().increment();
        moveUp(p);
    }
    public void remove(T ele) {
        Position<Item<T>> p = findPosition(ele);
        if(p != null) list.remove(p);
    }
    // return an iterable collection of k most frequently accessed elements
    public PositionalList<T> getFavorites(int k) throws IllegalArgumentException {
        if(k<0 || k>size())
            throw new IllegalArgumentException("Invalid k");
        PositionalList<T> result = new LinkedPositionalList<>();
        Iterator<Item<T>> iterator = list.iterator();
        for(int i=0; i<k; i++)
            result.addLast(iterator.next().getValue());
        return result;
    }

}
