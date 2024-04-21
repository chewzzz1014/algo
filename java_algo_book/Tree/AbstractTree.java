package Tree;

public abstract class AbstractTree<T> implements Tree<T> {
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
