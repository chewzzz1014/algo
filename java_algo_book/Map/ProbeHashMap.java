package Map;

import java.util.ArrayList;
import PriorityQueue.Entry;

public class ProbeHashMap<K,V> extends AbstractHashMap<K,V>{
    
    private MapEntry<K,V>[] table;
    private MapEntry<K,V> DEFUNCT = new MapEntry<>(null, null);

    public ProbeHashMap() {
        super();
    }
    public ProbeHashMap(int capacity) {
        super(capacity);
    }
    public ProbeHashMap(int capacity, int prime) {
        super(capacity, prime);
    }

    protected void createTable() {
        table = (MapEntry<K,V>[]) new MapEntry[capacity];
    }
    private boolean isAvailable(int i) {
        return (table[i] == null || table[i] == DEFUNCT);
    }

    // return index with key k, or -(a+1) such that k could be added at index a
    private int findSlot(int h, K k) {
        int available = -1;
        int i = h;
        do {
            if(isAvailable(i)) { // might be empty/defunct
                if(available == -1) available = i; // 1st available slot
                if(table[i] == null) break; // if empty, search fails
            } else if(table[i].getKey().equals(k)) {
                return i;
            }
            i = (i+1) % capacity;
        } while(i != h);
        return -(available + 1); // not found
    }

    protected V bucketGet(int h, K k) {
        int i = findSlot(h, k);
        if(i<0) return null;
        return table[i].getValue();
    }

    protected V bucketPut(int h, K k, V v) {
        int i = findSlot(h, k);
        // entry existed, overwrite
        if(i>=0) return table[i].setValue(v);
        // add entry
        table[-(i+1)] = new MapEntry<>(k, v);
        n++;
        return null;
    }

    protected V bucketRemove(int h, K k) {
        int i = findSlot(h, k);
        // not found
        if(i<0) return null;
        // mark slot as deactivated
        V answer = table[i].getValue();
        table[i] = DEFUNCT;
        n--;
        return answer;
    }

    public Iterable<Entry<K,V>> entrySet() {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>();
        for(int i=0; i<capacity; i++) {
            if(!isAvailable(i)) buffer.add(table[i]);
        }
        return buffer;
    }

}
