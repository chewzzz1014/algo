package PriorityQueue;

import java.util.Comparator;

import List.LinkedPositionalList;
import List.Position;
import List.PositionalList;

public class UnsortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {
    
    private PositionalList<Entry<K,V>> list = new LinkedPositionalList<>();

    public UnsortedPriorityQueue() {
        super();
    }
    public UnsortedPriorityQueue(Comparator<K> comparator) {
        super(comparator);
    }
    private Position<Entry<K,V>> findMin() {
        Position<Entry<K,V>> small = list.first();
        for(Position<Entry<K,V>> walk : list.positions()) {
            if(compare(walk.getElement(), small.getElement()) < 0)
                small = walk;
        }
        return small;
    }
    public Entry<K,V> insert(K k, V v) throws IllegalArgumentException {
        checkKey(k);
        Entry<K,V> newEntry = new PQEntry<>(k, v);
        list.addLast(newEntry);
        return newEntry;
    }
    public Entry<K,V> min() {
        if(list.isEmpty()) return null;
        return list.remove(findMin());
    }
    public Entry<K,V> removeMin() {
        if(list.isEmpty()) return null;
        return list.remove(findMin());
    }
    public int size() {
        return list.size();
    }
}
