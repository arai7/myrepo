class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[n][m];
        
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], -1);
        }

        //gather all sources
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    queue.add(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }

        int[][] directions = {
            {0, 1},  // Right
            {0, -1}, // Left
            {1, 0},  // Down
            {-1, 0}   // Up
        };

        //perf multi source bfs
        while(!queue.isEmpty()){
            int[] cordinates = queue.poll();
            int x = cordinates[0];
            int y = cordinates[1];

            for(int[] oneDirection : directions){
                int nx = x + oneDirection[0];
                int ny = y + oneDirection[1];

                if(nx >= 0 && nx < n && ny >=0 && ny < m && dist[nx][ny] == -1){
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return dist;
    }
}
