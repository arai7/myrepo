class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for(int row[] : memo){
            Arrays.fill(row, -1);
        }
        return bt(text1, 0, text2, 0, memo);
    }

    public int bt(String text1, int i, String text2, int j, int[][] memo){
        int res = 0;

        if(i >= text1.length() || j >= text2.length()){
            return 0;
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        if(text1.charAt(i) == text2.charAt(j)){
            memo[i][j] = 1 + bt(text1, i+1, text2, j+1, memo);
        }else{
            memo[i][j] = Math.max(bt(text1, i+1, text2, j, memo), bt(text1, i, text2, j+1, memo));
        }
        
        return memo[i][j];
    }
}
