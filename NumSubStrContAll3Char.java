class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3]; // To store frequency of 'a', 'b', 'c'
        int left = 0, result = 0, n = s.length();
        
        for (int right = 0; right < n; right++) {
            count[s.charAt(right) - 'a']++; // Expand the window
            
            // Shrink window while it contains all 'a', 'b', 'c'
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                result += n - right; // All substrings from left to end are valid
                count[s.charAt(left) - 'a']--; // Reduce count of leftmost character
                left++; // Move left pointer
            }
        }
        return result;
    }
}
