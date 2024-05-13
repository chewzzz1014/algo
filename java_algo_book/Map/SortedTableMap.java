package Map;

import java.util.Comparator;

import java.util.ArrayList;
import Map.AbstractMap.MapEntry;
import PriorityQueue.Entry;

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

    private Entry<K,V> safeEntry(int i) {
        if(i<0 || i>=table.size()) return null;
        return table.get(i);
    }

    public Entry<K,V> firstEntry() {
        return safeEntry(0);
    }
 
    public Entry<K,V> lastEntry() {
        return safeEntry(table.size() - 1);
    }

    public Entry<K,V> ceilingEntry(K key) {
        return safeEntry(findIndex(key));
    }

    public Entry<K,V> floorEntry(K key) {
        int i = findIndex(key);
        if(i == size() || !key.equals(table.get(i).getKey()))
            i--;
        return safeEntry(i);
    }

    public Entry<K,V> lowerEntry(K key) {
        return safeEntry(findIndex(key) - 1);
    }

    public Entry<K,V> higherEntry(K key) {
        int i = findIndex(key);
        if(i<size() && key.equals(table.get(i).getKey()))
            i++;
        return safeEntry(i);
    }

    private Iterable<Entry<K,V>> snapshot(int startIndex, K stop) {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>();
        int i = startIndex;
        while(i<table.size() && (stop == null || compare(stop, table.get(i)) > 0))
            buffer.add(table.get(i++));
        return buffer;
    }

    public Iterable<Entry<K,V>> entrySet() {
        return snapshot(0, null);
    }

    public Iterable<Entry<K,V>> subMap(K fromKey, K toKey) {
        return snapshot(findIndex(fromKey), toKey);
    }
}
