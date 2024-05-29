package topInterview150;

public class MaxSumCircularSubarray {
    
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int maxSum = nums[0];
        int curMax = 0;
        int minSum = nums[0];
        int curMin = 0;

        for(int n : nums) {
            // the usual max subarray sum (w/o circular)
            curMax = Math.max(curMax + n, n);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(curMin + n, n);
            minSum = Math.min(minSum, curMin);

            total += n;
        }

        // corner case
        // if all number are negative, maxSum=max(nums) and minSum=sum(nums)
        // so max(maxSum, total-minSum) = 0 (sum of empty subarray)
        if(maxSum <= 0) return maxSum;

        // 2 scenarios:
        // 1: subarray only takes middle part (usual max subarray sum)
        // 2: subarray takes part of head and part of tail. maxSum = total - minSum(refers to the middle part)
        return Math.max(maxSum, total - minSum);
    }
}
