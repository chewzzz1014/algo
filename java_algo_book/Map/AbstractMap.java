package Map;

import java.util.Iterator;

import PriorityQueue.Entry;

public abstract class AbstractMap<K,V> implements Map<K,V> {
    
    public boolean isEmpty() {
        return size() == 0;
    }

    // nested MapEntry class 
    protected static class MapEntry<K,V> implements Entry<K,V> {
        private K k;
        private V v;
        public MapEntry(K k, V v) {
            this.k = k;
            this.v = v;
        }
        public K getKey() {return k;}
        public V getValue() {return v;}
        protected void setKey(K k) {this.k = k;}
        protected V setValue(V v) {
            V old = this.v;
            this.v = v;
            return old;
        }
    }
    // end of MapEntry

    // nested KeyIterator and KeyIterable class
    private class KeyIterator implements Iterator<K> {
        private Iterator<Entry<K,V>> entries = entrySet().iterator();
        public boolean hasNext() {return entries.hasNext();}
        public K next() {return entries.next().getKey();}
        public void remove() {throw new UnsupportedOperationException();}
    }
    private class KeyIterable implements Iterable<K> {
        public Iterator<K> iterator() {return new KeyIterator();}
    }
    public Iterable<K> keySet() {return new KeyIterable();}
    // end of KeyIterator and KeyIterable

    // nested ValueIterator and ValueIterable class
    private class ValueIterator implements Iterator<V> {
        private Iterator<Entry<K,V>> entries = entrySet().iterator();
        public boolean hasNext() {return entries.hasNext();}
        public V next() {return entries.next().getValue();}
        public void remove() {throw new UnsupportedOperationException();}
    }
    private class ValueIterable implements Iterable<V> {
        public Iterator<V> iterator() {return new ValueIterator();}
    }
    public Iterable<V> values() {return new ValueIterable();}
    // end of ValueIterator and ValueIterable
}
