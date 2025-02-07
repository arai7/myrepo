import java.util.*;

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int low = 0, high = Collections.max(A);
        int result = 0;
        
        while (low < high) {
            int mid = low + (high - low) / 2 + 1;
            long woodCut = getWood(A, mid);
            
            if (woodCut >= B) { 
                // We found a valid height, but let's check if there's a higher valid height
                low = mid; 
            } else { 
                // Too little wood, lower the height
                high = mid - 1; 
            }
        }
        
        return high;  // The highest valid height found
    }

    private long getWood(ArrayList<Integer> A, int H) {
        long totalWood = 0;
        for (int tree : A) {
            if (tree > H) {
                totalWood += tree - H;
            }
        }
        return totalWood;
    }
}
