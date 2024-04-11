package topInterview150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> r = new HashMap<>();

        for(String s : strs) {
            // sort the word
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String k = new String(chars);

            if(!r.containsKey(k)) {
                r.put(k, new ArrayList<>());
            }
            r.get(k).add(s);
        }
        return new ArrayList<>(r.values());

    }
}
