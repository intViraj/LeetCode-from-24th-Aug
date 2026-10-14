class Solution {
    int [] parent;
    int [] rank;
    public int find(int a,int []parent){
        if(parent[a]==a)return a;
        return parent[a]=find(parent[a],parent);
    }

    public void union(int x,int y,int []parent,int [] rank){
        int x_parent=find(x,parent);
        int y_parent=find(y,parent);

        if(x_parent==y_parent)return ;

        if(rank[x_parent]==rank[y_parent]){
            parent[x_parent]=y_parent;
            rank[x_parent]++;
        }else if(rank[x_parent]>rank[y_parent]){
            parent[y_parent]=x_parent;
        }else{
            parent[x_parent]=y_parent;
        }
    }
    public boolean equationsPossible(String[] equations) {
        parent=new int[26];
        rank=new int[26];
        Arrays.fill(rank,0);
        for(int i=0;i<26;i++){
            parent[i]=i;
        }

        for(String s : equations){
            if(s.charAt(1)=='='){
                union(s.charAt(0)-'a',s.charAt(3)-'a',parent,rank);
            }
        }
        for(String s : equations){
            if(s.charAt(1)=='!'){
                char f=s.charAt(0);
                char l=s.charAt(3);

                int parentf=find(f-'a',parent);
                int parentl=find(l-'a',parent);

                if(parentf==parentl){
                    return false;
                }
            }
        }
        return true;
    }
}