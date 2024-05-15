package topInterview150;

public class HouseRobber {
    
    public int rob(int[] nums) {
        if(nums.length ==0 ) return 0;

        /* Approach 1: Iteration + Tabulation */
        // int n = nums.length;
        // int[] dp = new int[n+1];
        // dp[0] = 0;
        // dp[1] = nums[0];

        // for(int i=1; i<n; i++) {
        //     dp[i+1] = Math.max(dp[i], dp[i-1]+nums[i]);
        // }
        // return dp[n];

        /* Approach 2: 2 Var */
        int prev1 = 0;
        int prev2 = 0;
        for(int n : nums) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + n);
            prev2 = temp;
        }
        return prev1;
    }
}
