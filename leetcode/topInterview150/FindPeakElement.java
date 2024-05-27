package topInterview150;

public class FindPeakElement {
    
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while(start + 1 < end) {
            int mid = (start + end) / 2;
            if(nums[mid] > nums[mid + 1]) { // found it!
                end = mid;
            } else {
                start = mid;
            }
        }

        // increasing pattern
        if(nums[start] > nums[end]) {
            return start;
        } else { // decreasing pattern
            return end;
        }
    }
}
