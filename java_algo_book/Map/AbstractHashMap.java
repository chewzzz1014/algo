import java.util.Random;

import java.util.ArrayList;
import PriorityQueue.Entry;

public abstract class AbstractHashMap<K,V> extends AbstractMap<K,V> {
    protected int n = 0; // num of entries
    protected int capacity; // length of table
    private int prime; // prime factor
    private long scale, shift;

    public AbstractHashMap(int capacity, int prime) {
        this.prime = prime;
        this.capacity = capacity;
        Random random = new Random();
        scale = random.nextInt(prime-1) + 1;
        shift = random.nextInt(prime);
        createTable();
    }
    public AbstractHashMap(int capacity) {
        this(capacity, 109345121);
    }
    public AbstractHashMap() {
        this(17);
    }

    public int size() {
        return n;
    }
    public V get(K key) {
        return bucketGet(hashValue(key), key);
    }
    public V remove(K key) {
        return bucketRemove(hashValue(key), key);
    }
    public V put(K key, V value) {
        V answer = bucketPut(hashValue(key), key, value);
        if(n > capacity / 2) // if load factor > 0.5
            resize(2 * capacity - 1);
        return answer;
    }

    private int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);
    }
    private void resize(int newCapacity) {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>();
        for(Entry<K,V> e : entrySet())
            buffer.add(e);
        capacity = newCapacity;
        createTable();
        n = 0;
        for(Entry<K,V> e : buffer)
            put(e.getKey(), e.getValue());
    }
    // to be implemented by subclasses
    protected abstract void createTable();
    protected abstract V bucketGet(int h, K k);
    protected abstract V bucketPut(int h, K k, V v);
    protected abstract V bucketRemove(int h, K k);
}