package PriorityQueue;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {
    
    // nested class: PQEntry
    protected static class PQEntry<K,V> implements Entry<K,V> {
        private K k;
        private V v;
        public PQEntry(K k, V v) {
            this.k = k;
            this.v = v;
        }
        public K getKey() {return k;}
        public V getValue() {return v;}
        protected void setKey(K k) {this.k = k;}
        protected void setValue(V v) {this.v = v;}
    }
    // end of PQEntry

    // comparator
    private Comparator<K> comp;
    protected AbstractPriorityQueue(Comparator<K> comp) {
        this.comp = comp;
    }
    protected AbstractPriorityQueue() {
        this(new DefaultComparator<K>());
    }
    protected int compare(Entry<K,V> a, Entry<K,V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }
    // check whether a key is valid (can compare to itself)
    protected boolean checkKey(K k) throws IllegalArgumentException {
        try {
            return (comp.compare(k, k) == 0);
        } catch(ClassCastException e) {
            throw new IllegalArgumentException("Incompatible class");
        }
    }
    public boolean isEmpty() {
        return size() == 0;
    }
}
