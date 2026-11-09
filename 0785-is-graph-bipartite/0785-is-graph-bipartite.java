class Solution {
    
    public boolean DFS(int [][] graph ,int curr,int []color ,int currColor){
        color[curr]=currColor;

        for(int v : graph[curr]){
            if(color[curr]==color[v])return false;
            else if(color[v]==-1){
                color[v]=1-currColor;
                if(!DFS(graph,v,color,1-currColor))return false;
            }
        }
        return true;
    }

    //BFS

    public boolean BFS(int [][] graph,int curr,int [] color,int currColor){
        Queue<Integer> q=new LinkedList<>();

        q.add(curr);
        color[curr]=currColor;

        while(!q.isEmpty()){
            int present=q.poll();

            for(int v : graph[present]){
                if(color[v]==-1){
                    color[v]=1-color[present];
                    q.add(v);
                }
                else if(color[v]==color[present])return false;

            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int [] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(!BFS(graph,i,color,0)){
                    return false;
                }
            }
        }
        return true;
    }
}