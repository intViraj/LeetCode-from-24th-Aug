class Solution {
    int []parent;
    int [] rank;

    public int find(int a,int [] parent){
        if(parent[a]==a){
            return a;
        }
        return parent[a]=find(parent[a],parent);
    }

    public void union(int a,int b,int [] parent,int []rank){
        int parent_a=find(a,parent);
        int parent_b=find(b,parent);

        if(parent_a==parent_b)return;

        if(rank[parent_b]<rank[parent_a]){
            parent[parent_a]=parent_b;
        }else{
            parent[parent_b]=parent_a;
            rank[parent_a]=(rank[parent_a]==rank[parent_b]) ? rank[parent_a]+1 : rank[parent_a];
        }
    }

    public long countPairs(int n, int[][] edges) {
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        HashMap<Integer,Integer> components=new HashMap<>();
        for(int [] i : edges){
            int parent_u=find(i[0],parent);
            int parent_v=find(i[1],parent);

            if(parent_v==parent_u)continue;
            else{
                union(i[0],i[1],parent,rank);
            }
        }
        for(int i=0;i<n;i++){
            int currparent=find(i,parent);
            components.put(currparent,components.getOrDefault(currparent,0)+1);
        }
        long sum = 0;
        long prefixSum = 0;
        for(Map.Entry<Integer,Integer> entry : components.entrySet()){
            sum += prefixSum * entry.getValue();;
            prefixSum += entry.getValue();;
        }
        return sum;
    }
}