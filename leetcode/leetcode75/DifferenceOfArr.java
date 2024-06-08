package leetcode75;

import java.util.*;

public class DifferenceOfArr {
   
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for(int num : nums1) s1.add(num);
        for(int num : nums2) s2.add(num);

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());

        for(int num : s1) {
            if(!s2.contains(num)) result.get(0).add(num);
        }

        for(int num : s2) {
            if(!s1.contains(num)) result.get(1).add(num);
        }

        return result;
    }
}
