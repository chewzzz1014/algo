package PriorityQueue;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;;

public class HeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {
    
    protected List<Entry<K,V>> heap = new ArrayList<>();

    public HeapPriorityQueue() {
        super();
    }
    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }
    //  initialize priority queue with given key value pairs
    public HeapPriorityQueue(K[] keys, V[] values) {
        super();
        for(int i=0; i<Math.min(keys.length, values.length); i++)
            heap.add(new PQEntry<>(keys[i], values[i]));
        heapify();
    }
    // bottom-up construction of heap in linear time
    protected void heapify() {
        int startIndex = parent(size() - 1);
        // downheap on every non-leaf node
        for(int i=startIndex; i>=0; i--)
            downheap(i);
    }
    protected int parent(int i) {
        return (i-1) / 2;
    }
    protected int left(int i) {
        return 2*i + 1;
    }
    protected int right(int i) {
        return 2*i + 2;
    }
    protected boolean hasLeft(int i) {
        return left(i)<heap.size();
    }
    protected boolean hasRight(int i) {
        return right(i)<heap.size();
    }
    protected void swap(int i, int j) {
        Entry<K,V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    // moves entry at index i higher
    protected void upheap(int i) {
        while(i > 0) {
            int p = parent(i);
            // child > parent
            if(compare(heap.get(i), heap.get(p)) >= 0) break;
            swap(i, p);
            i = p;
        }
    }
    // move entry at index j lower
    protected void downheap(int i) {
        while(hasLeft(i)) {
            int leftIdx = left(i);
            int smallestIdx = leftIdx;
            
            if(hasRight(i)) {
                int rightIdx = right(i);
                smallestIdx = Math.min(smallestIdx, rightIdx);
            }

            if(compare(heap.get(smallestIdx), heap.get(i)) >= 0) break;
            swap(smallestIdx, i);
            i = smallestIdx;
        }
    }
    public int size() {
        return heap.size();
    }
    public Entry<K,V> min() {
        if(heap.isEmpty()) return null;
        return heap.get(0);
    }
    public Entry<K,V> insert(K k, V v) throws IllegalArgumentException {
        checkKey(k);
        Entry<K,V> newEntry = new PQEntry<>(k, v);
        heap.add(0, newEntry);
        upheap(heap.size() - 1);
        return newEntry;
    }
    public Entry<K,V> removeMin() {
        if(heap.isEmpty()) return null;
        Entry<K,V> root = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downheap(0);
        return root;
    }

}
