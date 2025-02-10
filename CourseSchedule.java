class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(!visited[i] && hasCycle(i, graph, visited, path)){
                return false;
            }
        }

        return true;
    }

    public boolean hasCycle(int i , List<List<Integer>> graph, boolean[] visited, boolean[] path){
        visited[i] = true;
        path[i] = true;

        for(int neighbor : graph.get(i)){
            if(!visited[neighbor] && hasCycle(neighbor, graph, visited, path)){
                return true;
            }
            else if(path[neighbor]){
                return true;
            }
        }
        path[i] = false;
        return false;
    }
}
