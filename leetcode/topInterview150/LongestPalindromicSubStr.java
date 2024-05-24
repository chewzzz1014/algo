package topInterview150;

public class LongestPalindromicSubStr {
    int maxLen = 0;
    int start = 0;

    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) return s;

        for(int i = 0; i < s.length(); i++) {
            helper(i, i, s);
            helper(i, i + 1, s);
        }

        return s.substring(start, start + maxLen);
    }

    private void helper(int left, int right, String s) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if(right - left + 1 > maxLen) {
                start = left;
                maxLen = right - left + 1;
            }
            left--;
            right++;
        }
    }
}
