class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);

        // Go through the matrix and merge connected cities
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // Avoid duplicate checks
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.countProvinces();
    }
}

// Union-Find class
class UnionFind {
    private int[] parent;
    private int[] rank;
    private int count; // Number of provinces (connected components)

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        count = n; // Initially, each city is its own province

        for (int i = 0; i < n; i++) {
            parent[i] = i; // Each node is its own parent
            rank[i] = 1;    // Initial rank is 1
        }
    }

    public int find(int x) {
        if (parent[x] != x) { // Path compression
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) { // If they belong to different sets
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else { // Same rank, merge and increase rank
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            count--; // Merging two components reduces the number of provinces
        }
    }

    public int countProvinces() {
        return count;
    }
}
