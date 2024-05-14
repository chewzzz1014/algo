package SearchTree;

import java.util.ArrayList;
import java.util.Comparator;

import List.Position;
import Map.AbstractSortedMap;
import PriorityQueue.Entry;

public class TreeMap<K,V> extends AbstractSortedMap<K,V> {
    
    protected BalanceableBinaryTree<K,V> tree = new BalanceableBinaryTree<>();

    public TreeMap() {
        super();
        tree.addRoot(null);
    }

    public TreeMap(Comparator<K> comparator) {
        super(comparator);
        tree.addRoot(null);
    }

    public int size() {
        return (tree.size() - 1) / 2;
    }

    // to insert new entry at leaf of tree
    private void expandExternal(Position<Entry<K,V>> p, Entry<K,V> entry) {
        tree.set(p, entry);
        tree.addLeft(p, null);
        tree.addRight(p, null);
    }

    protected Position<Entry<K,V>> root() {
        return tree.root();
    }

    // return position in p's subtree having given key
    private Position<Entry<K,V>> treeSearch(Position<Entry<K,V>> p, K key) {
        if(tree.isExternal(p))
            return p;
        int comparison = compare(key, p.getElement());
        if(comparison == 0)
            return p;
        else if(comparison < 0)
            return treeSearch(tree.left(p), key);
        else 
            return treeSearch(tree.right(p), key);
    }

    public V get(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K,V>> p = treeSearch(root(), key);
        tree.rebalanceAccess(p);
        if(tree.isExternal(p)) return null;
        return p.getElement().getValue();
    }

    public V put(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K,V> newEntry = new MapEntry<>(key, value);
        Position<Entry<K,V>> p = treeSearch(root(), key);
        if(tree.isExternal(p)) { // key not found
            expandExternal(p, newEntry);
            tree.rebalanceAccess(p);
            return null;
        } else {
            V old = p.getElement().getValue();
            tree.set(p, newEntry);
            tree.rebalanceAccess(p);
            return old;
        }
    }

    public V remove(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K,V>> p = treeSearch(root(), key);
        if(tree.isExternal(p)) { // key not found
            tree.rebalanceAccess(p);
            return null;
        } else {
            V old = p.getElement().getValue();

            // both children are internal: substitute key with max node in left subtree
            if(tree.isInternal(tree.left(p)) && tree.isInternal(tree.right(p))) {
                Position<Entry<K,V>> replacement = treeMax(tree.left(p));
                tree.set(p, replacement.getElement());
                p = replacement;
            }

            // at most one child is internal node
            Position<Entry<K,V>> leaf = tree.isExternal(tree.left(p)) ? tree.left(p) : tree.right(p);
            Position<Entry<K,V>> sibling = tree.sibling(leaf);
            tree.remove(leaf);
            tree.remove(p);
            tree.rebalanceDelete(sibling);
            return old;
        }
    }

    protected Position<Entry<K,V>> treeMax(Position<Entry<K,V>> p) {
        Position<Entry<K,V>> walk = p;
        while(tree.isInternal(walk))
            walk = tree.right(walk);
        return tree.parent(walk);
    }

    public Entry<K,V> lastEntry() {
        if(tree.isEmpty()) return null;
        return treeMax(root()).getElement();
    }

    // entry with max key <= key
    public Entry<K,V> floorEntry(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K,V>> p = treeSearch(root(), key);
        if(tree.isInternal(p))
            return p.getElement();
        while(!tree.isRoot(p)) {
            if(p == tree.right(tree.parent(p)))
                return tree.parent(p).getElement();
            else 
                p = tree.parent(p);
        }
        return null;
    }

    // entry with max key which < key
    public Entry<K,V> lowerEntry(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K,V>> p = treeSearch(root(), key);
        if(tree.isInternal(p) && tree.isInternal(tree.left(p)))
            return treeMax(tree.left(p)).getElement();
        while(!tree.isRoot(p)) {
            if(p == tree.right(p))
                return tree.parent(p).getElement();
            else 
                p = tree.parent(p);
        }
        return null;
    }

    public Iterable<Entry<K,V>> entrySet() {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>(size());
        for(Position<Entry<K,V>> p : tree.inorder())
            if(tree.isInternal(p)) buffer.add(p.getElement());
        return buffer;
    }

    // entries with keys in range [fromKey, toKey)
    public Iterable<Entry<K,V>> subMap(K fromKey, K toKey) {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>(size());
        if(compare(fromKey, toKey) < 0)
            subMapRecurse(fromKey, toKey, root(), buffer);
        return buffer;
    }

    private void subMapRecurse(K fromKey, K toKey, Position<Entry<K,V>> p, ArrayList<Entry<K,V>> buffer) {
        if(tree.isInternal(p)) {
            if(compare(p.getElement(), fromKey) < 0)

        }
    }
}
