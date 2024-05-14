package topInterview150;

import java.util.Stack;

public class KSmallestBST {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        int count = 0;

        // preorder traversal DFS
        while(p != null || !stack.isEmpty()) {
            // keep going left till meet null node
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                // pop the node w/o left node
                p = stack.pop();

                count++;
                if(count == k) return p.val;

                p = p.right;
            }
        }

        return -1;
    }
    
}
