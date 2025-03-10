class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int res = 0;
        int count = 1; // To count the length of current alternating sequence

        for (int i = 1; i < n + k - 1; i++) {  // Simulating extended array
            if (colors[i % n] != colors[(i - 1) % n]) {
                count++;
            } else {
                count = 1; // Reset if pattern breaks
            }

            // Only count valid alternating sequences of length k
            if (count >= k) {
                res++;
            }
        }

        return res;
    }
}
