package topInterview150;

import java.util.*;

public class AverageLevelInBT {
    
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        
        if(root == null) return result;

        // BFS queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // BFS traversal == traverse each level
        double levelSum = 0;
        while(!queue.isEmpty()) {
            levelSum = 0;
            int levelSize = queue.size();
            for(int i=0; i<levelSize; i++) {
                TreeNode current = queue.poll();
                levelSum += current.val;
                if(current.left != null)
                    queue.add(current.left);
                if(current.right != null)
                    queue.add(current.right);
            }
            result.add(levelSum / levelSize);
        }

        return result;
    }
}
