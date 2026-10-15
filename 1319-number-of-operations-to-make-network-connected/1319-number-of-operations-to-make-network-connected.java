class Solution {
    int[]parent;
    int [] rank;

    public int find(int a){
        if(parent[a]==a){
            return a;
        }
        return parent[a]=find(parent[a]);
    }

    public void union(int a ,int b){
        int a_parent=find(a);
        int b_parent=find(b);

        if(a_parent==b_parent)return;

        if(rank[a_parent]<rank[b_parent]){
            parent[a_parent]=b_parent;
        }else if(rank[a_parent]>rank[b_parent]){
            parent[b_parent]=a_parent;
        }else{
            parent[b_parent]=a_parent;
            rank[a_parent]++;
        }
    }

    public int cycles(int[][] connections,int V,int components){
        for(int []i : connections){
            int parent_u=find(i[0]);
            int parent_v=find(i[1]);
            if(parent_u==parent_v){
                continue;
            }else{
                union(i[0],i[1]);
                components--;
            }
        }
        
        return components;
    }
    public int makeConnected(int n, int[][] connections) {
        if(n-1>connections.length){
            return -1;
        }
        parent=new int [n];
        rank=new int [n];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
    
        return cycles(connections,n,n)-1;

    }
}