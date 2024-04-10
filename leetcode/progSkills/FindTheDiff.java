package progSkills;

public class FindTheDiff {
    public char findTheDifference(String s, String t) {
        // bitwise approach: XOR every chars of both strs
        char c = 0;
        for(char cs : s.toCharArray()) c ^= cs;
        for(char ct : t.toCharArray()) c ^= ct;
        return c;
    }
}
