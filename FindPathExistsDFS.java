class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            adjList.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int[] visited = new int[n];
        return dfs(source, destination, adjList, visited);

    }

    public boolean dfs(int current, int destination, HashMap<Integer, List<Integer>> adjList, int[] visited){
        visited[current] = 1;
        if(current == destination){
            return true;
        }
        for(int neighbor : adjList.get(current)){
            if (visited[neighbor] == 0) {
            if (dfs(neighbor, destination, adjList, visited)) {  // <-- check here
                return true;
            }
        }
        }
        return false;
    }
}
