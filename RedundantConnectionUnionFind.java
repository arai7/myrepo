class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];

        // Initialize: each node is its own parent
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int rep0 = find(edge[0], parent);
            int rep1 = find(edge[1], parent);

            if (rep0 == rep1) {
                return edge;
            }

            union(rep0, rep1, parent);
        }

        return null; // Problem guarantees there is always one redundant connection
    }

    public int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent); // path compression
        }
        return parent[x];
    }

    public void union(int x, int y, int[] parent) {
        if (x <= y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
}
