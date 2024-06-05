package topInterview150;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstrWithoutRepeated {
    
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 1;
        int left = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }

            maxLen = Math.max(maxLen, i-left+1);
            map.put(c, i);
        }

        return maxLen;
    }    
}
