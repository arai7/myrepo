class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        int[] parent = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(isConnected[i][j] == 1){
                    union(parent, i, j);
                }
            }
        }

        Set<Integer> provinces = new HashSet<>();
        for(int i = 0; i < n; i++){
            provinces.add(find(parent, i));
        }

        return provinces.size();
    }

    public int find(int[] parent, int x){
        if(parent[x] != x){
            parent[x] = find(parent, parent[x]);
        }

        return parent[x];
    }

    public void union(int[] parent, int x, int y){
        int repX = find(parent, x);
        int repY = find(parent, y);

        if(repX != repY){
            parent[repY] = repX;
        }
    }
}
