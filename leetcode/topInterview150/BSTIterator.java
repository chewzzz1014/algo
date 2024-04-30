package topInterview150;

import java.util.*;

public class BSTIterator {
    TreeNode current;
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        current = root;
        stack = new Stack<>();
    }
    
    public int next() {
        while(current != null) {
            stack.push(current);
            current = current.left;
        }
        TreeNode next = stack.pop();
        current = next.right;
        return next.val;
    }
    
    public boolean hasNext() {
        return current != null || !stack.empty();
    }
}
