class Solution {

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n]; // DP table for memoization
        int start = 0; // Starting index of the longest palindrome
        int maxLength = 0; // Length of the longest palindrome

        // Helper function for checking palindromes
        for (int len = 1; len <= n; len++) { // len is the length of substring
            for (int left = 0; left <= n - len; left++) {
                int right = left + len - 1; // right index of substring
                
                // Base cases
                if (len == 1) {
                    dp[left][right] = true; // Single character is a palindrome
                } else if (len == 2) {
                    dp[left][right] = (s.charAt(left) == s.charAt(right));
                } else {
                    // Check recursively
                    dp[left][right] = (s.charAt(left) == s.charAt(right)) && dp[left + 1][right - 1];
                }

                // Update the longest palindrome
                if (dp[left][right] && len > maxLength) {
                    maxLength = len;
                    start = left;
                }
            }
        }

        // Return the longest palindrome substring
        return s.substring(start, start + maxLength);
    }
}
