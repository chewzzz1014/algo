public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        // reverse entire array
        reverse(nums, 0, nums.length-1);

        // reverse first k elements
        reverse(nums, 0, k-1);
        
        // reverse k+1 to nums.length-1 elements
        reverse(nums, k, nums.length-1);
    }

    void reverse(int[] nums, int l, int r) {
        while (l<r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
