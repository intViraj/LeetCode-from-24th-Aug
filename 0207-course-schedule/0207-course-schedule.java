class Solution {
    public boolean DFS(HashMap<Integer, ArrayList<Integer>> graph,int curr,boolean[] visited,boolean[] recstack){
        visited[curr] = true;
        recstack[curr] = true;

        for (int neighbor : graph.get(curr)) {
            if (!visited[neighbor]) {
                if (DFS(graph, neighbor, visited, recstack)) {
                    return true;
                }
            } else if (recstack[neighbor]) {
                return true;
            }
        }
        recstack[curr] = false;
        return false;
    }
    public boolean BFS(HashMap<Integer, ArrayList<Integer>> graph,int curr,boolean[] visited,int[] indegree){
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)
            q.add(i);
        }

        while(!q.isEmpty()){
            int now=q.poll();
            if(visited[now])continue;
            visited[now]=true;
            for(int i=0;i<graph.get(now).size();i++){
                int neighbour=graph.get(now).get(i);
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    q.add(neighbour);
                }
            }
        }
        for(boolean i:visited){
            if(!i)return true;
        }
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        int [] indegree=new int [numCourses];
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] recstack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                // if (DFS(graph, i, visited, recstack)) {
                //     return false;
                // }
                if(BFS(graph,i,visited,indegree)){
                    return false;
                }
            }
        }
        return true;
    }
}