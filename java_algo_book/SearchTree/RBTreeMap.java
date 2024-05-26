package SearchTree;

import java.util.Comparator;

import List.Position;
import PriorityQueue.Entry;

public class RBTreeMap<K,V> extends TreeMap<K,V> {
    
    public RBTreeMap() {
        super();
    }

    public RBTreeMap(Comparator<K> comparator) {
        super(comparator);
    }

    // 0 = black and 1 = red
    private boolean isBlack(Position<Entry<K, V>> p) {
        return tree.getAux(p) == 0;
    }
    private boolean isRed(Position<Entry<K, V>> p) {
        return tree.getAux(p) == 1;
    }
    private void makeBlack(Position<Entry<K, V>> p) {
        tree.setAux(p, 0);
    }
    private void makeRed(Position<Entry<K, V>> p) {
        tree.setAux(p, 1);
    }
    private void setColor(Position<Entry<K, V>> p, boolean toRed) {
        tree.setAux(p, toRed ? 1 : 0);
    }

    protected void rebalanceInsert(Position<Entry<K, V>> p) {
        if(!tree.isRoot(p)) {
            makeRed(p);
            resolveRed(p);
        }
    }

    private void resolveRed(Position<Entry<K, V>> p) {
        Position<Entry<K, V>> parent, uncle, middle, grand;
        parent = tree.parent(p);

        if(isRed(parent)) {
            uncle = tree.sibling(parent);
            if(isBlack(uncle)) {
                middle = tree.restructure(p);
                makeBlack(middle);
                makeRed(tree.left(middle));
                makeRed(tree.right(middle));
            } else {
                makeBlack(parent);
                makeBlack(uncle);
                grand = tree.parent(parent);
                if(!tree.isRoot(grand)) {
                    makeRed(grand);
                    resolveRed(grand);
                }
            }
        }
    }

    protected void rebalanceDelete(Position<Entry<K, V>> p) {
        if(isRed(p)) {
            makeBlack(p);
        } else if(!tree.isRoot(p)) {
            Position<Entry<K, V>> sibling = tree.sibling(p);
            if(tree.isInternal(sibling) && (isBlack(sibling) || tree.isInternal(tree.left(p))))
                remedyDoubleBlack(p);
        }
    }

    private void remedyDoubleBlack(Position<Entry<K, V>> p) {
        Position<Entry<K, V>> z = tree.parent(p);
        Position<Entry<K, V>> y = tree.sibling(p);

        if(isBlack(y)) {
            if(isRed(tree.left(y)) || isRed(tree.right(y))) { // case 1: trinode restructuring
                Position<Entry<K, V>> x = (isRed(tree.left(y)) ? tree.left(y) : tree.right(y));
                Position<Entry<K, V>> middle = tree.restructure(x);
                setColor(middle, isRed(z));
                makeBlack(tree.left(middle));
                makeBlack(tree.right(middle));
            } else { // case 2: recoloring
                makeRed(y);
                if(isRed(z)) makeBlack(z);
                else if(!tree.isRoot(z)) remedyDoubleBlack(z);
            }
        } else { // case 3: reorient 3-node
            tree.rotate(y);
            makeBlack(y);
            makeRed(z);
            remedyDoubleBlack(p);
        }
    }
}
