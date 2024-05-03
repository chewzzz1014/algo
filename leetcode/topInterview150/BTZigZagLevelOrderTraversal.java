package topInterview150;

import java.util.*;

public class BTZigZagLevelOrderTraversal {
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        int direction = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<queueSize; i++) {
                TreeNode current = queue.poll();

                if(direction > 0) temp.add(current.val);
                else temp.add(0, current.val);

                if(current.left != null)
                    queue.add(current.left);
                if(current.right != null)
                    queue.add(current.right);
            }
            result.add(temp);
            direction *= -1;
        }
        return result;
    }
}
