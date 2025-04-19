class Solution {
    public boolean isBipartite(int[][] graph) {
        int noOfNodes = graph.length;
        int[] colorTrack = new int[noOfNodes];

        for (int i = 0; i < noOfNodes; i++) {
            if (colorTrack[i] == 0) {
                if (!dfs(graph, i, colorTrack, 1)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int[][] graph, int curr, int[] colorTrack, int color) {
        if (colorTrack[curr] != 0) {
            return colorTrack[curr] == color;
        }

        colorTrack[curr] = color;

        for (int neighbor : graph[curr]) {
            if (!dfs(graph, neighbor, colorTrack, -color)) {
                return false;
            }
        }

        return true;
    }
}
