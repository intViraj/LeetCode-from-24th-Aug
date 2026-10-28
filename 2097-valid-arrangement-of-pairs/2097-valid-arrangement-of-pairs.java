class Solution {
    public int[][] validArrangement(int[][] pairs) {
        int n=pairs.length;
        HashMap<Integer,Deque<Integer>> graph=new HashMap<>();
        HashMap<Integer,Integer> degree=new HashMap<>();

        for(int i=0;i<n;i++){
            int u=pairs[i][0];
            int v=pairs[i][1];

            graph.computeIfAbsent(u , K-> new ArrayDeque<>()).add(v);
            graph.computeIfAbsent(v , K-> new ArrayDeque<>());

            degree.put(u,degree.getOrDefault(u,0)+1);
            degree.put(v,degree.getOrDefault(v,0)-1);
        }

        int start=pairs[0][0];

        for(int node : degree.keySet()){
            if(degree.get(node)==1){
                start=node;
                break;
            }
        }
        ArrayList<Integer> path=new ArrayList<>();
        Stack<Integer> stk=new Stack<>();

        stk.push(start);

        while(!stk.isEmpty()){
            int node=stk.peek();

            if(!graph.get(node).isEmpty()){
                stk.push(graph.get(node).pollFirst());
            }else{
                path.add(stk.pop());
            }
        }

        Collections.reverse(path);
        int [][] result=new int[n][2];
        for(int i=0;i<pairs.length;i++){
            result[i][0]=path.get(i);
            result[i][1]=path.get(i+1);
        }
        return result;
    }
}