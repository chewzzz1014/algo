public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) {
            return true;
        }

        int sub = 0;
        for(int i=0; i<t.length(); i++) {
            if(s.charAt(sub) == t.charAt(i)) {
                sub++;
                if(sub == s.length()) return true;
            }
        }
        return false;
    }
}
