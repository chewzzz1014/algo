package topInterview150;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        // when any character in ransomNote is not a part of magazine, return false

        if(ransomNote.length() > magazine.length()) return false;
        int[] alpha = new int[26];

        for(char c : magazine.toCharArray())
            alpha[c - 'a']++;

        for(char c : ransomNote.toCharArray()) {
            if(alpha[c - 'a'] == 0) return false;
            // decrement: to avoid reusing the same character
            alpha[c - 'a']--;
        }
        return true;
    }
}
