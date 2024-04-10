package progSkills;

public class RepeatedSubstr {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        for(int i=n/2; i>=1; i--) {
            // if the length of substring is divisible
            if(n%i == 0) {
                int m = n/i;
                String sub = s.substring(0, i);

                int j;
                for(j=1; j<m; j++) {
                    if (!sub.equals(s.substring(j*i, i+j*i))) break;
                }
                
                if(j == m) return true;
            }
        }
        return false;
    }
}
