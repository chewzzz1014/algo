package leetcode75;

import java.util.*;

public class UniqueNumOccurence {
    
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Integer> occurence = new HashSet<>(map.values());

        return occurence.size() == map.size();
    }
}
