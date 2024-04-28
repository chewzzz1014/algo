package topInterview150;

public class InvertBinaryTree {
    
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.left != null)
                stack.push(node.left);

            if(node.right != null)
                stack.push(node.right);
        }

        return root;
    }
}
