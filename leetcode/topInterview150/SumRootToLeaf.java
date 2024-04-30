package topInterview150;

public class SumRootToLeaf {
     public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode n, int s) {
        if(n == null) return 0;

        // if it's leaf node
        if(n.right == null && n.left == null)
            return s*10 + n.val;
        return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
    }
}
