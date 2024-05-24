package topInterview150;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1+1][n2+1];

        // initialize first row: when s1="", delete j elements
        for(int j = 1; j<=n2; j++) {
            dp[0][j] = j;
        }

        // initialize first col: when s2 = "", delete i elements
        for(int i = 1; i<=n1; i++) {
            dp[i][0] = i;
        }

        for(int i = 1; i<=n1; i++) {
            for(int j = 1; j<=n2; j++) {
                char c1 = word1.charAt(i-1);
                char c2 = word2.charAt(j - 1);

                if(c1 == c2) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                }
            }
        }

        return dp[n1][n2];
    }
}
