package topInterview150;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity, count;
    private Map<Integer, Node> map;
    private Node head, tail;

    private class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
        Node() {
            this(0, 0);
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    // accessed the element and set it as the most recent node
    public int get(int key) {
        Node n = map.get(key);
        if(n == null) return -1;
        update(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        Node n = map.get(key);
        // not exist. add to linked list
        if(n == null) {
            n = new Node(key, value);
            map.put(key, n);
            add(n);
            count++;
        } else {
            // existed. set it as the most recent node
            n.value = value;
            update(n);
        }

        // if bursted, remove last node
        if(count > capacity) {
            Node toDel = tail.prev;
            remove(toDel);
            map.remove(toDel.key);
            count--;
        }
    }

    // place the node as first node
    private void update(Node node) {
        remove(node);
        add(node);
    }

    // insert node as first node
    private void add(Node node) {
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }

    // remove a node
    private void remove(Node node) {
        Node before = node.prev, after = node.next;
        before.next = after;
        after.prev = before;
    }
}
