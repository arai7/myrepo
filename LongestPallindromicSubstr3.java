class Solution {
    
    public static String longestPalindrome(String s) {
        int n = s.length();
        Boolean[][] memo = new Boolean[n][n]; // Memoization table
        int[] longest = {0, 0}; // Store start and end indices of the longest palindrome

        // Recursively check for palindromes
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j, memo)) {
                    if (j - i > longest[1] - longest[0]) {
                        longest[0] = i;
                        longest[1] = j;
                    }
                }
            }
        }

        // Return the longest palindrome substring
        return s.substring(longest[0], longest[1] + 1);
    }

    private static boolean isPalindrome(String s, int left, int right, Boolean[][] memo) {
        // Base case: A single character or empty string is a palindrome
        if (left >= right) {
            return true;
        }

        // If result is already computed, return it
        if (memo[left][right] != null) {
            return memo[left][right];
        }

        // Recursive case
        if (s.charAt(left) == s.charAt(right) && isPalindrome(s, left + 1, right - 1, memo)) {
            memo[left][right] = true;
        } else {
            memo[left][right] = false;
        }

        return memo[left][right];
    }
}
