package topInterview150;

public class FirstLastElementSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        return new int[] {left, right};
    }

    private int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left + 1 < right) {
            int mid = (left + right) / 2;
            if(nums[mid] >= target) { // *if found or target is on left of mid (prefer left target)
                right = mid; // as usual
            } else {
                left = mid;
            }
        }

        if(nums[left] == target) return left; // prioritize leftmost target found
        else if(nums[right] == target) return right;
        else return -1;
    }

    private int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left + 1 < right) {
            int mid = (left + right) / 2;
            if(nums[mid] <= target) { // *if found or target is on left of mid (prefer right target)
                left = mid; // as usual
            } else {
                right = mid;
            }
        }

        if(nums[right] == target) return right; // prioritize rightmost target found
        else if(nums[left] == target) return left;
        return -1;
    }
}
