import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> mySet = new HashSet<>();
        for (int num : nums) {
            if (!mySet.add(num)) {
                return true; // duplicate found
            }
        }
        return false; // no duplicates
    }
}
