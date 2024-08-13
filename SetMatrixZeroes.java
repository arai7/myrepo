class Solution {
    public void setZeroes(int[][] matrix) {
        Queue<int[]> q = new LinkedList<>();
        int n =matrix.length;
        int m=matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    q.add(new int[]{ i,j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] it = q.poll();
            int r = it[0];
            int c = it[1];
            for(int i=0;i<m;i++){
                matrix[r][i]=0;
            }
            for(int i=0;i<n;i++){
                matrix[i][c]=0;
            }
        }
    }
}
