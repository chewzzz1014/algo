package topInterview150;

public class FlattenBTToLinkedList {
    private TreeNode prev;

    // reversed postorder traversal: right -> left -> root
    public void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
