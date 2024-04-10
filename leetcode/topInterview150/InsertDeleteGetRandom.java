import java.util.ArrayList;
import java.util.HashMap;

public class InsertDeleteGetRandom {
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> locs;
    java.util.Random random = new java.util.Random();

    public InsertDeleteGetRandom() {
        nums = new ArrayList<>();
        locs = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if (!locs.containsKey(val)) {
            locs.put(val, nums.size()); // track location of this val
            nums.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if (locs.containsKey(val)) {
            int loc = locs.get(val);
            if (loc < nums.size() - 1) { // if this val is not the last ele
                // swap last one with this
                int lastone = nums.get(nums.size()-1);
                nums.set(loc, lastone);
                locs.put(lastone, loc);
            }
            locs.remove(val);
            nums.remove(nums.size()-1);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}
