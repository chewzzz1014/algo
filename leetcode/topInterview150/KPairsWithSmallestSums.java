package topInterview150;

import java.util.*;

public class KPairsWithSmallestSums {
    
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums1.length==0 || nums2.length==0 || k==0) return result;

        // min heap
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        Set<String> visited = new HashSet<>();

        // visit the (0,0) pair
        heap.add(new int[] {nums1[0]+nums2[0], 0, 0});
        visited.add("0,0");

        while(k>0 && !heap.isEmpty()) {
            // pop the smallest and add to result
            int[] current = heap.poll();
            int i = current[1];
            int j = current[2];
            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[i]);
            temp.add(nums2[j]);
            result.add(temp);
            String pair = "";

            pair = (i+1) + "," + j;
            if(i+1<nums1.length && !visited.contains(pair)) {
                heap.add(new int[] {nums1[i+1]+nums2[j], i+1, j});
                visited.add(pair);
            }
            pair = i + "," + (j+1);
            if(j+1<nums2.length && !visited.contains(pair)) {
                heap.add(new int[] {nums1[i]+nums2[j+1], i, j+1});
                visited.add(pair);
            }
            k--;
        }
        return result;
    }
}
