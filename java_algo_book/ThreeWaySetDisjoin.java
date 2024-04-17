public class ThreeWaySetDisjoin {
    
    public static boolean disjoin1(int[] groupA, int[] groupB, int[] groupC) {
        for(int a : groupA)
            for(int b : groupB)
                for(int c : groupC)
                    if((a==b) && (b==c))
                        return false;
        return true;
    }

    public static boolean disjoin2(int[] groupA, int[] groupB, int[] groupC) {
        for(int a : groupA)
            for(int b : groupB)
                if(a == b)
                    for(int c : groupC)
                        if (a==c)
                            return false;
        return true;
    }
}
