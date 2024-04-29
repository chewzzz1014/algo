package topInterview150;

public class PathSum {
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) 
            return false;

        // reduce as we go down. if the remaining is 0 at the leaf. return true
        if(root.left == null && root.right == null && targetSum - root.val == 0)
            return true;

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
