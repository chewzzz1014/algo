package progSkills;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int[] alpha = new int[26];

        for(int i=0; i<c1.length; i++) {
            alpha[c1[i] - 'a']++;
            alpha[c2[i] - 'a']--;
        }
        
        for(int n : alpha) {
            if  (n != 0) return false;
        }
        return true;
    }
}
