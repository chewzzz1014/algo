package topInterview150;

public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left+1 < right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;

            if(nums[left] <= nums[mid]) { // left partiton is sorted, check left partition
                if(nums[left]<=target && target<=nums[mid]) { // left partition
                    right = mid;
                } else {
                    left = mid;
                }
            } else { //right partiton is sorted, check right partition
                if(nums[mid]<=target && target<=nums[right]) { // right partition
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }

        if(nums[left] == target) return left;
        else if(nums[right] == target) return right;
        else return -1;
    }
}
