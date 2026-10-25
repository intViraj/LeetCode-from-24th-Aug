class Solution {
    public class Node{
        int wt;
        int node;
        Node(int wt,int node){
            this.wt=wt;
            this.node=node;
        }
    }
    public int prims(ArrayList<ArrayList<Node>> graph , boolean[] visited,int src,PriorityQueue<Node> min){
        int sum=0;
        min.add(new Node(0,src));

        while(!min.isEmpty()){
            Node curr=min.poll();

            if(visited[curr.node])continue;
            sum+=curr.wt;
            visited[curr.node]=true;
            for(Node v : graph.get(curr.node)){
                if(!visited[v.node]){
                    min.add(new Node(v.wt,v.node));
                }
            }
        }
        return sum;

    }
    public int minCostConnectPoints(int[][] points) {
        ArrayList<ArrayList<Node>> graph=new ArrayList<>();
        int V=points.length;
        boolean [] visited=new boolean[V+1];
        PriorityQueue<Node> min=new PriorityQueue<>((a,b) -> Integer.compare(a.wt,b.wt));
        int sum=0;

        for(int i=0;i<V;i++){
            int x1=points[i][0];
            int y1=points[i][1];
            ArrayList<Node> list=new ArrayList<>();
            for(int j=0;j<V;j++){
                if(j==i)continue;
                int x2=points[j][0];
                int y2=points[j][1];
                int wt=Math.abs(x1-x2) + Math.abs(y1-y2);
                list.add(new Node(wt,j));
            }
            graph.add(list);
        }

        return prims(graph,visited,0,min);
    }
}