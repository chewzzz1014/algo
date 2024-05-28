package topInterview150;


// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}


class QuadTree {
    public Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length - 1, grid[0].length -1);
    }

    // x1=row start, x2=row end
    // y1=col start, y2=col end
    private Node helper(int[][] grid, int x1, int y1, int x2, int y2) {
        if(x1>x2 || y1>y2) return null;

        int val = grid[x1][y1];
        boolean same = true;

        for(int i=x1; i<=x2; i++) {
            for(int j=y1; j<=y2; j++) {
                // there's element diff from current element's val
                // mean this ele has leaf, we need to have the 4 children
                if(grid[i][j] != val) {
                    same = false;
                    break;
                }
            }
        }

        Node node = new Node();

        // all elements are same, it's leaf and return it
        if(same) {
            node.isLeaf = true;
            node.val = val == 1;
            return node;
        }

        // get the leaf
        int rowMid = (x1 + x2) / 2;
        int colMid = (y1 + y2) / 2;

        node.isLeaf = false;

        node.topLeft = helper(grid, x1, y1, rowMid, colMid);
        node.topRight = helper(grid, x1,  colMid + 1, rowMid, y2);
        
        node.bottomLeft = helper(grid, rowMid+1, y1, x2, colMid);
        node.bottomRight = helper(grid, rowMid+1, colMid+1, x2, y2);
        return node;
    }
}