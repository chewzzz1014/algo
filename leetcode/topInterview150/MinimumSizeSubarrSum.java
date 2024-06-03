package topInterview150;

public class MinimumSizeSubarrSum {
    
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            while(left<=i && sum>=target) { // make the window as small as possible
                result = Math.min(result, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
