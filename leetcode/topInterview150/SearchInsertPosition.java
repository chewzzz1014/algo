package topInterview150;

public class SearchInsertPosition {
    
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start+1 < end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if(target <= nums[start]) {
            return start;
        } else if(target <= nums[end]) {
            return end;
        } else if(target > nums[end]) {
            return end + 1;
        }

        return -1;
    }
}
