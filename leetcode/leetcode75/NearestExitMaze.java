package leetcode75;

import java.util.*;

public class NearestExitMaze {
    
    public int nearestExit(char[][] maze, int[] entrance) {
        // BFS
        int rows = maze.length;
        int columns = maze[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        int steps = 0;
        int x, y;
        while(!queue.isEmpty()) {
            steps++;

            int n = queue.size();
            for(int i=0; i<n; i++) {
                int[] curr = queue.poll();

                for(int[] direction : directions) {
                    x = curr[0] + direction[0];
                    y = curr[1] + direction[1];

                    // out of found or is wall, cant continue this direction
                    if(x<0 || x>=rows || y<0 || y>=columns) continue;
                    if(maze[x][y] == '+') continue;

                    // if reach boundary
                    if(x==0 || x==rows-1 || y==0 || y==columns-1) return steps;

                    maze[x][y] = '+';
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return -1;
    }
}
