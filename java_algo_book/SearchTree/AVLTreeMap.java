package SearchTree;

import java.util.Comparator;

import List.Position;
import PriorityQueue.Entry;

public class AVLTreeMap<K,V> extends TreeMap<K,V> {
    
    public AVLTreeMap() {
        super();
    }

    public AVLTreeMap(Comparator<K> comparator) {
        super(comparator);
    }

    protected int height(Position<Entry<K,V>> p) {
        return tree.getAux(p);
    }

    protected void recomputeHeight(Position<Entry<K,V>> p) {
        tree.setAux(p, 1 + Math.max(height(tree.left(p)), height(tree.right(p))));
    }

    protected boolean isBalanced(Position<Entry<K,V>> p) {
        return Math.abs(height(tree.left(p)) - height(tree.right(p))) <= 1;
    }

    protected Position<Entry<K,V>> tallerChild(Position<Entry<K,V>> p) {
        if(height(tree.left(p)) > height(tree.right(p))) return tree.left(p);
        if(height(tree.left(p)) < height(tree.right(p))) return tree.right(p);
        if(tree.isRoot(p)) return tree.left(p);
        if(p == tree.left(tree.parent(p))) return tree.left(p);
        else return tree.right(p);
    }

    protected void rebalance(Position<Entry<K,V>> p) {
        int oldHeight, newHeight;
        do {
            oldHeight = height(p);
            if(!isBalanced(p)) {
                p = tree.restructure(tallerChild(tallerChild(p)));
                recomputeHeight(tree.left(p));
                recomputeHeight(tree.right(p));
            }
            recomputeHeight(p);
            newHeight = height(p);
            p = tree.parent(p);
        } while(oldHeight != newHeight && p != null);
    }

    protected void rebalanceInsert(Position<Entry<K,V>> p) {
        rebalance(p);
    }

    protected void rebalanceDelete(Position<Entry<K,V>> p) {
        if(!tree.isRoot(p))
            rebalance(tree.parent(p));
    }
}
