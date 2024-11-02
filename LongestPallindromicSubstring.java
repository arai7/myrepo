class Solution {
    public String longestPalindrome(String s) 
    {
        if (s == null || s.length() < 1) 
            return "";
        
        String longest = "";
        
        for (int i = 0; i < s.length(); i++) 
        {
            // Check for odd-length palindromes (single character center)
            String oddPalindrome = expandAroundCenter(s, i, i);
            // Check for even-length palindromes (two character center)
            String evenPalindrome = expandAroundCenter(s, i, i + 1);
            
            // Update the longest palindrome found
            if (oddPalindrome.length() > longest.length()) 
            {
                longest = oddPalindrome;
            }
            if (evenPalindrome.length() > longest.length()) 
            {
                longest = evenPalindrome;
            }
        }
        
        return longest;
    }
    
    private String expandAroundCenter(String s, int left, int right) 
    {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))        
        {
            left--;
            right++;
        }
        return s.substring(left + 1, right); // Return the valid palindrome
    }
}
