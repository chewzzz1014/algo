package topInterview150;

import java.util.ArrayList;
import java.util.List;

public class BTRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode current, List<Integer> result, int currDepth) {
        if(current == null) return;

        // each depth only select one node
        if(currDepth == result.size()) {
            result.add(current.val);
        }

        rightView(current.right, result, currDepth + 1);
        rightView(current.left, result, currDepth + 1);
    }
}
