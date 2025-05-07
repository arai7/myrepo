class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n < 2){
            return s;
        }
        
        String[][] memo = new String[n][n];
        return dfs(s, 0, n-1, memo);
    }

    public String dfs(String s, int l, int r, String[][] memo){
        if(l > r){
            return "";
        }

        if(memo[l][r] != null){
            return memo[l][r];
        }

        if(isPalindrome(s, l, r)){
            memo[l][r] = s.substring(l, r+1);
            return memo[l][r];
        }

        String left = dfs(s, l+1, r, memo);
        String right = dfs(s, l, r-1, memo);

        memo[l][r] = left.length() > right.length() ? left : right ;
        return memo[l][r];
    }

    public boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
