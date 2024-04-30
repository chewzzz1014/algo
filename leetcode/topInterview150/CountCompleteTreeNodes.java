package topInterview150;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
       if(root == null) return 0;

       int lh = leftHeight(root);
       int rh = rightHeight(root);
       if(lh == rh)
        return (int) Math.pow(2, lh) - 1; // 2 ^ height - 1

        return countNodes(root.left) + countNodes(root.right) + 1;
    }   

    private int leftHeight(TreeNode node) {
        return node == null ? 0 : 1 + leftHeight(node.left);
    }

    private int rightHeight(TreeNode node) {
        return node == null ? 0 : 1 + rightHeight(node.right);
    }
}
