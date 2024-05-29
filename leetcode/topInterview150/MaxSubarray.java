package topInterview150;

public class MaxSubarray {
    
    public int maxSubArray(int[] nums) {
        // kandane algorithm
        int overallMax = Integer.MIN_VALUE;
        int currMax = 0;

        for(int n : nums) {
            currMax += n;
            overallMax = Math.max(overallMax, currMax);
            if(currMax < 0) currMax = 0;
        }

        return overallMax;
    }
}
