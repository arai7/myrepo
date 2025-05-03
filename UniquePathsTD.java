class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        return dfs(m, n, 0, 0, memo);
    }

    public int dfs(int m, int n, int i, int j, int[][] memo){
        if(i == m-1 && j == n-1){
            return 1;
        }
        if(i < 0 || i >= m || j < 0 || j >= n){
            return 0;
        }

        if(memo[i][j] != -1){
            return memo[i][j];
        }

        int[][] dirs = {{0, 1}, {1, 0}};
        int paths = 0;

        for(int[] dir : dirs){
            int newX = i + dir[0];
            int newY = j + dir[1];

            int res = dfs(m, n, newX, newY, memo);
            paths += res;
        }

        memo[i][j] = paths;
        return paths;
    }
}
