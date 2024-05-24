package topInterview150;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        if(n1 + n2 != n3) return false;
        if(n1 == 0 && n2 == 0 && n3 == 0) return true;

        boolean[][] dp = new boolean[n1+1][n2+1];
        dp[0][0] = true;

        // initialize first row
        for(int j = 1; j<=n2; j++) {
            if(s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1] == true) {
                dp[0][j] = true;
            }
        }

        // initialize first column
        for(int i = 1; i<=n1; i++) {
            if(s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0] == true) {
                dp[i][0] = true;
            }
        }

        for(int i = 1; i<=n1; i++) {
            for(int j = 1; j<=n2; j++) {
                // if take s1[i-1]
                if(s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i-1][j] == true) {
                    dp[i][j] = true;
                }


                // if take s2[j-1]
                if(s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1] == true) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[n1][n2];
    }
}
