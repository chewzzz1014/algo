package topInterview150;

import java.util.HashSet;
import java.util.Set;

public class ContainDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        // iterate using sliding window
        // front is at i, rear is k steps back
        for(int i=0; i<nums.length; i++) {
            //remove element if its distance to nums[i] is not lesser than k
            if(i > k) set.remove(nums[i-k-1]);

            // because all still existed elements is closer than k distance to the num[i]
            // therefore if the add() return false, it means there's a same value element already existed within the distance k and return true.
            if(!set.add(nums[i])) return true;
        }

        return false;
    }
}
