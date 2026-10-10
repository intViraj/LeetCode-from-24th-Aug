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
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] recstack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (DFS(graph, i, visited, recstack)) {
                    return false;
                }
            }
        }
        return true;
    }
}