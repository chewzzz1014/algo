package Map;

import java.util.Comparator;

import java.util.ArrayList;
import Map.AbstractMap.MapEntry;

public class SortedTableMap<K,V> extends AbstractSortedMap<K,V> {
    
    private ArrayList<MapEntry<K,V>> table = new ArrayList<>();

    public SortedTableMap() {
        super();
    }
    public SortedTableMap(Comparator<K> comparator) {
        super(comparator);
    }

    // smallest index >= k
    private int findIndex(K key, int low, int high) {
        if(high<low) return high + 1;
        int mid = (low + high) / 2;
        int comparison = compare(key, table.get(mid));
        if(comparison == 0)
            return mid;
        else if(comparison < 0)
            return findIndex(key, low, mid-1);
        else
            return findIndex(key, mid+1, high);
    }

    private int findIndex(K key) {
        return findIndex(key, 0, table.size() - 1);
    }

    public int size() {
        return table.size();
    }

    public V get(K key) {
        int i = findIndex(key);
        if(i == size() || compare(key, table.get(i)) != 0) return null;
        return table.get(i).getValue();
    }

    public V put(K key, V value) {
        int i = findIndex(key);
        if(i<size() && compare(key, table.get(i)) == 0)
            return table.get(i).setValue(value);
        table.add(i, new MapEntry<>(key, value));
        return null;
    }

    public V remove(K key) {
        int i = findIndex(key);
        if(i == size() || compare(key, table.get(i)) != 0) return null;
        return table.remove(i).getValue();
    }

    
    
}
