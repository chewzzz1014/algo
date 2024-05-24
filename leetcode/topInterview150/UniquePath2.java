package topInterview150;

public class UniquePath2 {
     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid.length];
        dp[0] = 1;

        for(int j = 0; j < obstacleGrid[0].length; j++) {
            for(int i = 0; i < obstacleGrid.length; i++) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i] = 0;
                } else if (i > 0) {
                    dp[i] += dp[i-1];
                }
            }
        }

        return dp[obstacleGrid.length - 1];
    }
}
