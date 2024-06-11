package leetcode75;

import java.util.*;

public class BTRightSideView {
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result, int level) {
        if(root == null) return;

        if(result.size() == level) {
            result.add(root.val);
        }

        helper(root.right, result, level+1);
        helper(root.left, result, level+1);
    }
}
