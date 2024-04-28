package topInterview150;

public class BTFromPreorderInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if(preStart > preorder.length || inStart > inEnd)
            return null;
        
        // root is first node in preorder
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; 
        for(int i = inStart; i<= inEnd; i++) {
            if(inorder[i] == root.val)
                inIndex = i;
        }

        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        // get the immediate right child index by skipping all the node on the left branches/subtrees of current node
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
