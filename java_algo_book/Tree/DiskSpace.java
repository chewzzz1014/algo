package Tree;

import List.Position;

public class DiskSpace {
    
    // return total disk space for subtree of T rooted at p (postorder traversal)
    public static int diskSpace(Tree<Integer> T, Position<Integer> p) {
        int subtotal = p.getElement();
        for(Position<Integer> c : T. children(p))
            subtotal += diskSpace(T, c);
        return subtotal;
    }
}
