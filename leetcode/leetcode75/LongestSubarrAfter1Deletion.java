package leetcode75;

public class LongestSubarrAfter1Deletion {
    
     public int longestSubarray(int[] nums) {
        int i=0, j=0;
        int count = 0;
        int maxLen = 0;

        for(; j<nums.length; j++) {
            if(nums[j] == 0) count++;

            while(i<nums.length && count > 1) {
                if(nums[i] == 0) count--;
                i++;
            }  
            maxLen = Math.max(maxLen, j-i);     
        }

        return maxLen;
    }
}
