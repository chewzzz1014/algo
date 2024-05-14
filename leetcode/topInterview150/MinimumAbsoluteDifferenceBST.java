package topInterview150;

public class MinimumAbsoluteDifferenceBST {
    
    public int getMinimumDifference(TreeNode root) {
        int[] min = {Integer.MAX_VALUE};
        TreeNode[] prev = new TreeNode[1];

        inOrder(root, prev, min);
        return min[0];
    }

    private void inOrder(TreeNode root, TreeNode[] prev, int[] min) {
        if(root == null) return;
        
        inOrder(root.left, prev, min);

        if(prev != null && prev[0] != null) {
            min[0] = Math.min(min[0], root.val - prev[0].val);
        }
        prev[0] = root;

        inOrder(root.right, prev, min);
    }
}
