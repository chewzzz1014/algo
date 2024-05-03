package topInterview150;

import java.util.*;

public class BTLevelOrderTraversal {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<queueSize; i++) {
                TreeNode current = queue.poll();
                temp.add(current.val);
                if(current.left != null)
                    queue.add(current.left);
                if(current.right != null)
                    queue.add(current.right);
            }
            result.add(temp);
        }

        return result;
    }
}
