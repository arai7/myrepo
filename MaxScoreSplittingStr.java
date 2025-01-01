class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int maxScore = 0;

        // Count the total number of 1's in the string
        int totalOnes = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
            }
        }

        int leftZeros = 0;
        int rightOnes = totalOnes;

        // Iterate through valid split points (0 to n-2)
        for (int i = 0; i < n - 1; i++) {
            // Update leftZeros and rightOnes based on current character
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }

            // Calculate the score for this split
            int score = leftZeros + rightOnes;
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }
}
