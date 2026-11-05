class Solution {
    int [][] directions=new int [][]{{1,0} ,{0,1} ,{0,-1} ,{-1,0}};
    
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n=grid.size();
        int m=grid.get(0).size();

        Deque<int[]> q=new ArrayDeque<>();
        boolean [][] visited=new boolean[n][m];
        int [][] dist=new int[n][m];
        for(int []i :dist){
            Arrays.fill(i,Integer.MAX_VALUE);
        }

        dist[0][0]=grid.get(0).get(0);
        q.add(new int[]{0,0});
        // visited[0][0]=true;
        if (dist[0][0] >= health) return false;

        while(!q.isEmpty()){
            int [] curr=q.pollFirst();
            visited[curr[0]][curr[1]]=true;
            for(int [] dir : directions){
                int x=dir[0]+curr[0];
                int y=dir[1]+curr[1];

                if(x>=n || x<0 || y>=m ||y<0 || visited[x][y]){
                    continue;
                }
                if(dist[x][y] > dist[curr[0]][curr[1]] + grid.get(x).get(y)){
                    dist[x][y] = dist[curr[0]][curr[1]] + grid.get(x).get(y);
                    if(grid.get(x).get(y) == 1){
                        q.addLast(new int[]{x,y});
                    }else{
                        q.addFirst(new int[]{x,y});
                    }
                }
            }
        }
        return dist[n-1][m-1]<health;
    }
}