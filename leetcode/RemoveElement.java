public class RemoveElement {
        public int removeElement(int[] nums, int val) {
            int i = 0;
            for (int ele:nums) {
                if (ele != val) nums[i++] = ele;
            }
            return i;
        }
}
