package PriorityQueue;

import java.util.Comparator;

import List.LinkedPositionalList;
import List.Position;
import List.PositionalList;

public class SortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {
    
    private PositionalList<Entry<K,V>> list = new LinkedPositionalList<>();

    public SortedPriorityQueue() {
        super();
    }
    public SortedPriorityQueue(Comparator<K> comparator) {
        super(comparator);
    }
    // O(N) 
    public Entry<K,V> insert(K k, V v) throws IllegalArgumentException {
        checkKey(k);
        Entry<K,V> newEntry = new PQEntry<>(k, v);
        Position<Entry<K,V>> walk = list.last();

        while(walk != null && compare(newEntry, walk.getElement()) < 0)
            walk = list.before(walk);
        if(walk == null)
            list.addFirst(newEntry);
        else
            list.addAfter(walk, newEntry); // walk -> newEntry
        return newEntry;
    }
    public Entry<K,V> min() {
        if(list.isEmpty()) return null;
        return list.first().getElement();
    }
    public Entry<K,V> removeMin() {
        if(list.isEmpty()) return null;
        return list.remove(list.first());
    }
    
}
