package leetcode75;

public class BSTDeleteNode {
    
     public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        } else{
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            // left and right not null
            // find max in left subtree or min in right subtree
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            // recursivelt delete the min val in right subtree
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while(node.left != null)
            node = node.left;
        return node;
    }
}
