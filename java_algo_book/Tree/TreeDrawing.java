package Tree;

import List.Position;

public class TreeDrawing {
    
    // inorder traversal fpr computing graphical layout of BT
    // x increase left to right, y increae top to bottom
    public static<T> int layout(BinaryTree<T> T, Position<T> p, int d, int x) {
        if(T.left(p) != null)
            x = layout(T, T.left(p), d+1, x);
        p.getElement().setX(x++);
        p.getElement().setY(d);
        if(T.right(p) != null)
            x = layout(T, T.right(p), d+1, x);
        return x;
    }

}
