public class FirstOccurrenceIndex {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length();
        int l2 = needle.length();

        // case 1: first str shorter than second str, return -1
        // case 2: target str is empty, return 0
        if (l1<l2) return -1;
        else if (l2==0) return 0;

        int threshold = l1-l2;
        for(int i=0; i<=threshold; i++) {
            if(haystack.substring(i, i+l2).equals(needle))
                return i;
        }
        return -1;
    }
}
