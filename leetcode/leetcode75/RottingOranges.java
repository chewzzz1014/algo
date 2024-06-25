package leetcode75;

import java.util.*;

public class RottingOranges {
    
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        // BFS
        int steps = 0;
        int fresh = 0;

        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
                else if(grid[i][j] == 1) fresh++;
            }
        }

        if(fresh == 0) return 0;
        
        while(!queue.isEmpty()) {
            steps++;
            int queueSize = queue.size();

            for(int i=0; i<queueSize; i++) {
                int[] curr = queue.poll();
                for(int[] direction : directions) {
                    int x = curr[0] + direction[0];
                    int y = curr[1] + direction[1];

                    if(x<0 || x>=m || y<0 || y>=n) continue;
                    if(grid[x][y] == 2 || grid[x][y] == 0) continue;

                    grid[x][y] = 2;
                    queue.offer(new int[] {x, y});
                    fresh--;
                }
            }
        }

        return fresh == 0 ? steps-1 : -1;
    }
}
