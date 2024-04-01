public class MajorityElement {
    public int majorityElement(int[] nums) {
        // Moore Voting Algorithm: if there is a majority element in an array, it will always remain in the lead, even after encountering other elements.
        int count = 0;
        int candidate = 0;

        for (int ele:nums) {
            if (count == 0) {
                candidate = ele;
            }
            
            if(ele == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
