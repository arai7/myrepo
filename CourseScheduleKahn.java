class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            int to = edge[0];
            int from = edge[1];

            adjList.get(from).add(to);
        }

        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            for(int j : adjList.get(i)){
                indegree[j]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int complete = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            complete++;

            for(int neighbor : adjList.get(curr)){
                indegree[neighbor]--;

                if(indegree[neighbor] == 0){
                    q.offer(neighbor);
                }

            }
        }

        return complete == numCourses;

    }
}
