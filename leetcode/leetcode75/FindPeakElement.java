package leetcode75;

public class FindPeakElement {
    
    public int findPeakElement(int[] nums) {
        // single element
        if(nums.length == 1) return 0;

        int n = nums.length;
        // first or last element is the peak
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        // other ele is peak
        int left=1, right=n-2;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) return mid;
            else if(nums[mid] < nums[mid-1]) right = mid-1;
            else if(nums[mid] < nums[mid+1]) left = mid + 1;
        }
        return -1;
    }
}
