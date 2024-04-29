package topInterview150;

public class BTFromInorderPostorder {
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(0, postorder.length - 1, 0, inorder.length-1, inorder, postorder);
    }

    private TreeNode helper(int postStart, int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder) {
        if(postStart > postEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = 0;
        for(int i=inStart; i<=inEnd; i++) {
            if(inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }

        int numLeftNodes = inIndex - inStart;
        int numRightNodes = inEnd - inIndex;
        root.left = helper(postStart, postStart + numLeftNodes - 1, inStart, inIndex - 1, inorder, postorder);
        root.right = helper(postEnd - numRightNodes, postEnd - 1, inIndex + 1, inEnd, inorder, postorder);

        return root;
    }
}
