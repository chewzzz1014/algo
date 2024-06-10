package leetcode75;

public class PathSum3 {
    
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        return (int)help(root, (long) targetSum)
            + pathSum(root.left, targetSum)
            + pathSum(root.right, targetSum);
    }

    private long help(TreeNode node, long targetSum) {
        if(node == null) return 0;

        return (node.val == targetSum ? 1 : 0)
        + help(node.left, targetSum - node.val)
        + help(node.right, targetSum - node.val);
    }
}
