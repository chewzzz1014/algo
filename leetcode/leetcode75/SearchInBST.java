package leetcode75;

public class SearchInBST {
    
     public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;

        return val<root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
