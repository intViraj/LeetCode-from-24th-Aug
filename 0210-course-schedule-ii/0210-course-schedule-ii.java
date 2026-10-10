class Solution {
    public void DFS(int numCourses,ArrayList<ArrayList<Integer>> graph,int start,boolean[]visited,Stack<Integer> stk){
        visited[start]=true;
        for(int i=0;i<graph.get(start).size();i++){
            int neighbour=graph.get(start).get(i);
            if(!visited[neighbour]){
                DFS(numCourses,graph,neighbour,visited,stk);
            }
        }
        stk.push(start);
    }
    public int[] BFS(int numCourses,ArrayList<ArrayList<Integer>> graph,boolean[]visited,int[]indegree){
        int []result=new int [numCourses];
        int idx=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            if(visited[curr]){
                continue;
            }
            visited[curr]=true;
            result[idx++]=curr;
            for(int i=0;i<graph.get(curr).size();i++){
                int neighbour=graph.get(curr).get(i);
                indegree[neighbour]--;
                if(indegree[neighbour]==0)q.add(neighbour);
            }
        }
        for(boolean i : visited){
            if(!i){
                return new int[0];
            }
        }
        return result;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        int [] result=new int [numCourses];
        if(prerequisites.length==0 && numCourses!=0){
            for(int i=0;i<numCourses;i++){
                result[i]=i;
            }
            return result;
        }
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int []indegree=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        boolean [] visited=new boolean [numCourses];

        int idx=0;
        Stack<Integer> stk=new Stack<>();
        // for(int i=0;i<numCourses;i++){
        //     if(!visited[prerequisites[i][1]]){
        //         // DFS(numCourses,graph,i,visited,stk);
        //     }
        // }
        result=BFS(numCourses,graph,visited,indegree);
        
        // while(!stk.isEmpty()){
        //     result[idx++]=stk.pop();
        // }
        return result;
    }
}