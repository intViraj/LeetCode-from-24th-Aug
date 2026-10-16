class Solution {
    public class Node{
        int wt;
        int dest;
        Node(int dest,int wt){
            this.wt=wt;
            this.dest=dest;
        }
    }
    public void dijkstra(ArrayList<ArrayList<Node>> graph, int [] dist,int src,TreeSet<Node>set){
       set.add(new Node(src,0));
       dist[src]=0;

       while(!set.isEmpty()){
            Node curr=set.removeFirst();
            int u=curr.dest;
            int t=curr.wt;
            if (t > dist[u]) {
                continue;
            }
            for(Node i : graph.get(u)){
                int v=i.dest;
                int d=i.wt;
                if(dist[v]>t+i.wt){
                    set.remove(new Node(v,dist[v]));
                    dist[v]=t+i.wt;
                    set.add(new Node(v,dist[v]));
                }
            }
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Node>> graph=new ArrayList<>();
        int[] result=new int [n+1];
        Arrays.fill(result,Integer.MAX_VALUE);
        TreeSet<Node> set=new TreeSet<>((a,b) ->{
            if (a.wt != b.wt) {
                return Integer.compare(a.wt, b.wt);
            }
            return Integer.compare(a.dest, b.dest);
        });
        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<>());
        }
        for(int [] i : times){
            graph.get(i[0]).add(new Node(i[1],i[2]));
        }
        dijkstra(graph,result,k,set);
        int min=0;
        for(int i=1;i<n+1;i++){
            min=Math.max(min,result[i]);
        }
        return min==Integer.MAX_VALUE ? -1 : min;
    }
}