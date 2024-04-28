package Tree;

import java.util.*;
import Tree.Position;
import java_algo_book.LinkedQueue;

public abstract class AbstractTree<T> implements Tree<T> {

    // nested ElementIterator class
    private class ElementIterator implements Iterator<T> {
        Iterator<Position<T>> posIterator = positions().iterator();
        public boolean hasNext() {
            return posIterator.hasNext();
        }
        public T next() {
            return posIterator.next().getElement();
        }
        public void remove() {
            posIterator.remove();
        }
    }
    // end of nested ElementIterator

    public Iterator<T> iterator() {
        return new ElementIterator();
    }

    // default traversal is preorder
    public Iterable<Position<T>> positions() {
        return preorder();
    }

    // preorder traversal
    private void preorderSubtree(Position<T> p, List<Position<T>> snapshot) {
        snapshot.add(p);
        for(Position<T> c : children(p))
            preorderSubtree(c, snapshot);
    }
    public Iterable<Position<T>> preorder() {
        List<Position<T>> snapshot = new ArrayList<>();
        if(!isEmpty())
            preorderSubtree(root(), snapshot);
        return snapshot;
    }

    //postorder traversal
    private void postorderSubtree(Position<T> p, List<Position<T>> snapshot) {
        for(Position<T> c : children(p))
            postorderSubtree(c, snapshot);
        snapshot.add(p);
    }
    public Iterable<Position<T>> postOrder() {
        List<Position<T>> snapshot = new ArrayList<>();
        if(!isEmpty())
            postorderSubtree(root(), snapshot);
        return snapshot;
    }

    // bread-first traversal
    public Iterable<Position<T>> breadFirst() {
        List<Position<T>> snapshot = new ArrayList<>();
        if(!isEmpty()) {
            Queue<Position<T>> fringe = new <>();

        }
        return snapshot;
    }

    public boolean isInternal(Position<T> p) {
        return numChildren(p) > 0;
    }
    public boolean isExternal(Position<T> p) {
        return numChildren(p) == 0;
    }
    public boolean isRoot(Position<T> p) {
        return p == root();
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public int depth(Position<T> p) {
        if(isRoot(p))
            return 0;
        else
            return 1 + depth(parent(p));
    }
    // height of tree: calc and find the max depth of leaf
    private int heightBad() {
        int h = 0;
        for(Position<T> p : positions()) {
            if(isExternal(p))
                h = Math.max(h, depth(p));
        }
        return h;
    }
    // height of substree rooted at p
    public int height(Position<T> p) {
        int h = 0;
        for(Position<T> c : children(p))
            h = Math.max(h, 1 + height(c));
        return h;
    }
}
