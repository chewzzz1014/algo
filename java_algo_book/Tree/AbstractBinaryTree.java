package Tree;

import java.util.ArrayList;
import java.util.List;
import List.Position;

public abstract class AbstractBinaryTree<T> extends AbstractTree<T> implements BinaryTree<T> {
    
    public Position<T> sibling(Position<T> p) {
        Position<T> parent = parent(p);
        // p is root
        if(parent == null)
            return null;
        if(p == left(parent))
            return right(parent);
        else
            return left(parent);
    }

    public int numChildren(Position<T> p) {
        int count = 0;
        if(left(p) != null)
            count++;
        if(right(p) != null)
            count++;
        return count;
    }

    public Iterable<Position<T>> children(Position<T> p) {
        List<Position<T>> snapshot = new ArrayList<>();
        if(left(p) != null)
            snapshot.add(left(p));
        if(right(p) != null)
            snapshot.add(right(p));
        return snapshot;
    }

    // in order traversal (preorder and postorder are in AbstractTree)
    private void inorderSubtree(Position<T> p, List<Position<T>> snapshot) {
        if(left(p) != null)
            inorderSubtree(left(p), snapshot);
        snapshot.add(p);
        if(right(p) != null)
            inorderSubtree(right(p), snapshot);
    }
    public Iterable<Position<T>> inorder() {
        List<Position<T>> snapshot = new ArrayList<>();
        if(!isEmpty())
            inorderSubtree(root(), snapshot);
        return snapshot;
    }

    // default traversal for BT is inorder traversal
    @Override
    public Iterable<Position<T>> positions() {
        return inorder();
    }
}
