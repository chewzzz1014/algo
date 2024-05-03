package PriorityQueue;

import java.util.Comparator;

// new utilities: remove(e), updateKey(e), updateValue(e)
public class HeapAdaptablePriorityQueue<K,V> extends HeapPriorityQueue<K,V> implements AdaptablePriorityQueue<K,V> {
  
    // nested AdaptablePQEntry class
    protected static class AdaptablePQEntry<K,V> extends PQEntry<K,V> {
        private int index;
        public AdaptablePQEntry(K k, V v, int i) {
            super(k, v);
            index = i;
        }
        public int getIndex() {return index;}
        public void setIndex(int i) {index = i;}
    }
    // end of AdaptablePQEntry

    public HeapAdaptablePriorityQueue() {
        super();
    }
    public HeapAdaptablePriorityQueue(Comparator<K> comp) {
        super(comp);
    }
    // validate an entry to ensure it's location-aware
    protected AdaptablePQEntry<K,V> validate(Entry<K,V> entry) throws IllegalArgumentException {
        // check if entry is instance of AdaptablePQEntry
        if(!(entry instanceof AdaptablePQEntry))
            throw new IllegalArgumentException("Invalid entry");
        AdaptablePQEntry<K,V> locator = (AdaptablePQEntry<K,V>) entry;

        int i = locator.getIndex();
        // validate the index
        if(i>=heap.size() || heap.get(i) != locator)
            throw new IllegalArgumentException("Invalid entry");
        return locator;
    }
    protected void swap(int i, int j) {
        super.swap(i, j);
        ((AdaptablePQEntry<K,V>) heap.get(i)).setIndex(i);
        ((AdaptablePQEntry<K,V>) heap.get(j)).setIndex(j);
    }
    protected void bubble(int i) {
        // if current node < its parent, bubble up
        if(i>0 && compare(heap.get(i), heap.get(parent(i))) < 0)
            upheap(i);
        else
            downheap(i);
    }
    @Override
    public Entry<K,V> insert(K k, V v) throws IllegalArgumentException {
        checkKey(k);
        Entry<K,V> newNode= new AdaptablePQEntry<>(k, v, heap.size());
        heap.add(newNode);
        upheap(heap.size()-1);
        return newNode;
    }
    public void remove(Entry<K,V> entry) throws IllegalArgumentException {
        AdaptablePQEntry<K,V> locator = validate(entry);
        int i = locator.getIndex();

        if(i == heap.size() - 1)
            heap.remove(heap.size() - 1);
        else {
            swap(i, heap.size()-1);
            heap.remove(heap.size()-1);
            bubble(i);
        }
    }
    public void replaceKey(Entry<K,V> entry, K k) throws IllegalArgumentException {
        AdaptablePQEntry<K,V> locator = validate(entry);
        checkKey(k);
        locator.setKey(k);
        bubble(locator.getIndex()); // with new key, may need to move entry
    }
    public void replaceValue(Entry<K,V> entry, V v) throws IllegalArgumentException {
        AdaptablePQEntry<K,V> locator = validate(entry);
        locator.setValue(v);
    }
}
