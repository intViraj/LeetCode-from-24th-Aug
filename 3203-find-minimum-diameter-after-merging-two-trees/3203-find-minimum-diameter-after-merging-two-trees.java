class Solution {
    public int[] BFS(HashMap<Integer,ArrayList<Integer>>graph ,int src,int n){
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(src);
        visited[src]=true;
        int distance = 0;
        int farthest = src;
       while(!q.isEmpty()){
        int len=q.size();

        for(int i=0;i<len;i++){
            int curr=q.poll();
            farthest=curr;
            for(int neighbour :graph.get(curr)){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    q.add(neighbour);
                }
            }
        }
        distance++;
       }
        return new int[]{farthest, distance - 1};
    }

    public int diameter(HashMap<Integer,ArrayList<Integer>> graph, int n){
        int [] first=BFS(graph,0,n);

        int [] second=BFS(graph,first[0],n);
        return second[1];
    }
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        HashMap<Integer,ArrayList<Integer>>graph1=new HashMap<>();
        HashMap<Integer,ArrayList<Integer>>graph2=new HashMap<>();
        int n=edges1.length+1;
        int m=edges2.length+1;

        for (int i = 0; i < n; i++) {
            graph1.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            graph2.put(i, new ArrayList<>());
        }
        
        for(int [] i :edges2){
            int u=i[0];
            int v=i[1];
            graph2.computeIfAbsent(u,K-> new ArrayList<>()).add(v);
            graph2.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        for(int [] i  : edges1){
            int u=i[0];
            int v=i[1];
            graph1.computeIfAbsent(u,K-> new ArrayList<>()).add(v);
            graph1.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        if(graph1.isEmpty() && graph2.isEmpty()){
            return 1;
        }
        if(graph2.isEmpty())return diameter(graph1,n);
        if(graph1.isEmpty())return diameter(graph2,m);
        int dia1=diameter(graph1,n);
        int dia2=diameter(graph2,m);

         int mergedDiameter = (dia1 + 1) / 2+ (dia2 + 1) / 2+ 1;

        return Math.max(Math.max(dia1, dia2),mergedDiameter);
    }
}