package leetcode75;

import java.util.Stack;

class NodeWrapper {
    TreeNode node;
    int currentMax = Integer.MIN_VALUE;

    public NodeWrapper(TreeNode node, int currentMax) {
        this.node = node;
        this.currentMax = Math.max(currentMax, node.val);
    }        
}

class CountGoodNode {
    public int goodNodes(TreeNode root) {
        int count = 0;
        Stack<NodeWrapper> s = new Stack<>();
        s.push(new NodeWrapper(root, root.val));

        while(!s.isEmpty()) {
            NodeWrapper curr = s.pop();

            count += curr.node.val >= curr.currentMax ? 1 : 0;

            if(curr.node.left != null)
                s.push(new NodeWrapper(curr.node.left, curr.currentMax));

            if(curr.node.right != null)
                s.push(new NodeWrapper(curr.node.right, curr.currentMax));
            
        }
        return count;
    }
}
