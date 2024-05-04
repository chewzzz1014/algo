package Map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import PriorityQueue.Entry;

public class UnsortedTableMap<K,V> extends AbstractMap<K,V> {
    
    private ArrayList<MapEntry<K,V>> table = new ArrayList<>();

    public UnsortedTableMap() {}

    private int findIndex(K k) {
        int n = table.size();
        for(int i=0; i<n; i++) {
            if(table.get(i).getKey().equals(k))
                return i;
        }
        return -1;
    }

    public int size() {return table.size();}

    public V get(K k) {
        int i = findIndex(k);
        if(i == -1) return null;
        return table.get(i).getValue();
    }

    public V put(K k, V v) {
        int i = findIndex(k);
        if(i == -1) {
            table.add(new MapEntry<>(k, v));
            return null;
        } else {
            return table.get(i).setValue(v);
        }
    }

    public V remove(K k) {
        int i = findIndex(k);
        int n = size();
        if(i == -1) return null;
        V answer = table.get(i).getValue();
        if(i != n-1)
            table.set(i, table.get(n-1));
        table.remove(n-1);
        return answer;
    }

    // nested EntryIterator and EntryIterable class
    private class EntryIterator implements Iterator<Entry<K,V>> {
        private int i = 0;
        public boolean hasNext() {return i<table.size();}
        public Entry<K,V> next() {
            if(i == table.size()) throw new NoSuchElementException();
            return table.get(i++);
        }
        public void remove() {throw new UnsupportedOperationException();}
    }
    private class EntryIterable implements Iterable<Entry<K,V>> {
        public Iterator<Entry<K,V>> iterator() {return new EntryIterator();}
    }
    public Iterable<Entry<K,V>> entrySet() {return new EntryIterable();}
    // end of EntryIterator and EntryIterable class

}
