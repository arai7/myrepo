class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; // Minimum possible eating speed
        int right = getMaxPile(piles); // Maximum possible eating speed
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEatAll(piles, h, mid)) {
                result = mid; // Try to minimize the speed
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    // Helper function to get the maximum pile size
    private int getMaxPile(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    private boolean canEatAll(int[] piles, int h, int k) {
    long hoursNeeded = 0; // Use long to prevent overflow
    for (int pile : piles) {
        hoursNeeded += (long) (pile + k - 1) / k; // Cast to long before the addition
        if (hoursNeeded > h) { // Early exit if we exceed the allowed hours
            return false;
        }
    }
    return hoursNeeded <= h;
}

}
