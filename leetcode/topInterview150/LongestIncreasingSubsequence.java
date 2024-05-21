package topInterview150;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int num : nums) {
            int index = helper(dp, num);
            dp[index] = num;
        }

        int result = 0;

        for(int num : dp) {
            if(num != Integer.MAX_VALUE) {
                result++;
            }
        }

        return result;
    }

    private int helper(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start + 1 < end) {
            int mid = (start + end) / 2;

            if(nums[mid] == target) return mid;

            if(nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return end;
    } 
}
