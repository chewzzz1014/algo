package leetcode75;

public class MaxVowelsKLength {

    public int maxVowels(String s, int k) {
        var vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int i=0, j=0;
        int maxCount = Integer.MIN_VALUE;
        int count = 0;

        // sliding window (i, j)
        for(; j<s.length(); j++) {
            if(vowels.contains(s.charAt(j)))
                count++;

            // if window size == k
            while(j-i+1 == k) {
                maxCount = Math.max(maxCount, count);
                // move left pointer
                if(i<s.length() && vowels.contains(s.charAt(i)))
                    count--;
                i++;
            }
        }
        return maxCount;
    }
}
