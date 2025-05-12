class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfs(0, s, memo);
    }

    private int dfs(int curr, String s, int[] memo){
        if(curr >= s.length()){
            return 1;
        }

        if(s.charAt(curr) == '0'){
            return 0;
        }

        if(memo[curr] != -1){
            return memo[curr];
        }

        int ways = dfs(curr+1, s, memo);

        if(curr + 1 < s.length()){
            int twoDigit = Integer.parseInt(s.substring(curr, curr + 2));
            if (twoDigit <= 26) {
                ways += dfs(curr + 2, s, memo);
            }
        }
        memo[curr] = ways;
        return ways;
    }
}
